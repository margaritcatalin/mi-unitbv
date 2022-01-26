package twoDimensional;

public class BinaryProcessor {
	private int[] input;
	private static BinaryProcessor instance;

	private BinaryProcessor() {

	}

	public static BinaryProcessor getInstance(int[] input) {
		if (instance == null) {
			instance = new BinaryProcessor();
		}
		instance.setInput(input);
		return instance;
	}

	public int[] getInput() {
		return input;
	}

	public void setInput(int[] input) {
		this.input = input;
	}

	public int[] toBinary() {
		int result[] = new int[input.length];
		for (int i = 0; i < input.length; i++)
			result[i] = Integer.parseInt(Integer.toBinaryString(input[i]));
		return result;
	}
}
