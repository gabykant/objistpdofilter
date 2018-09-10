<%@include file="header.jsp" %>

<div class="row">
	<div class="col-md-12">
		<div class="box">
			<h2>Messagerie Instantannee</h2>
			
			<div id="message">
			
			</div>

			<textarea id="inputMessage" cols="10" rows="5"></textarea>
			
			<button id="" onclick="send()">Send</button>
		</div>
	</div>
</div>

<script type="text/javascript">

	openSocket();
	var webSocket;
	var messages = document.getElementById('message');
	
	function openSocket()
	{
		if(webSocket !== undefined && webSocket.readyState !== WebSocket.CLOSED) {
			writeResponse("WebSocket is already opened");
			return;
		}
		
		webSocket = new WebSocket("ws://localhost:8080/Module8Seance12/serverchat");
		
		webSocket.onopen = function(event) {
			writeResponse(event.data);
		};
		
		webSocket.onmessage = function(event){
			writeResponse(event.data);
		};
		
		webSocket.onclose = function(event){
			writeResponse("Connection closed");
		};
	}
	
	function send()
	{
		var text = document.getElementById("inputMessage").value;
		webSocket.send(text);
	}
	
	function closeSocket()
	{
		webSocket.close();
	}
	
	function writeResponse(text)
	{
		messages.innerHTML += "<br />" + text;
	}
</script>

<%@include file="footer.jsp" %>