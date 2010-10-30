public class Deft {

	private static class ExampleRequestHandler extends RequestHandler {

		@Override
		public void get(HttpRequest request, HttpResponse response) {
			response.write("hello world");
		}

	}

	public static void main(String[] args) {
		Map<String, RequestHandler> reqHandlers = new HashMap<String, RequestHandler>();
		reqHandlers.put("/", new ExampleRequestHandler());
		Application application = new Application(reqHandlers);

		HttpServer server = new HttpServer(application);
		server.listen(8080);
		IOLoop.INSTANCE.start();	
	}
}
