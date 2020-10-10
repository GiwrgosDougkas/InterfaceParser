
public class Main {
	
	public static void main(String[] args) {
		
		Converter converter =new Converter();	
		Parser none=(s)->s;
		Parser ask=(s)->converter.toAsk(s);
		printer("Hello", new Parser() {

			@Override
			public String parser(String s) {
				
				return converter.toUpperCase(s);
			}});
		
		printer("My name",none);
		System.out.println(ask.parser("hello"));
		printer("is",(s)->converter.toExamination(s));
		printer("George",converter::toLowerCase);
		
	}
	
	public static void printer(String s, Parser p)
	{
		s=p.parser(s);
		System.out.println(s);
	}
}
