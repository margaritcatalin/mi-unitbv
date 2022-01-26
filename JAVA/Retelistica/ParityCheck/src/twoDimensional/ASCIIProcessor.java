package twoDimensional;

public class ASCIIProcessor {
	private String input;
	private static ASCIIProcessor instance;

	private ASCIIProcessor() {

	}

	public static ASCIIProcessor getInstance(String input) {
		if (instance == null) {
			instance = new ASCIIProcessor();
		}
		instance.setInput(input);
		return instance;
	}

	public String getInput() {
		return input;
	}

	public void setInput(String input) {
		this.input = input;
	}

	public int[] toASCII() {
		char[] character = input.toCharArray();
		int[] ascii = new int[input.length()];
		for (int i = 0; i < input.length(); i++) {
			ascii[i] = character[i];
		}
		return ascii;
	}
}
