/* Jessica Noel
 * CS 284 Section A
 * 2/10/2020
 * "I pledge my honor that I have abided by the Stevens Honor System"
 */


package BinaryNumber;

public class BinaryNumber {
		private int data[];
		private int length;

	public BinaryNumber(int length) {
		//checks the length of an input
		if(length <= 0) {
			System.out.println("Error: Length of number must be greater than 0");
		}

		//reassignment of values
		data = new int[length];
	}

	public BinaryNumber(String str) {
		//Will take a binary number and make it a string
		length = str.length();
		data = new int[length];
		for(int i=0; i < length; i++) {
			if(str.charAt(i) == '1') {
				data[i] = 1;
			}
			else if (str.charAt(i) == '0') {
				data[i] = 0;
			}
			else
				System.out.println("Error: Must be 0 or 1");
		}
	}
	// Will return an integer representing the binary length
	public int getLength() {
		return this.length;
	}

	public int getDigit(int index) {
		//Will return the number at a certain index
		if(index >= data.length) {
			throw new IllegalArgumentException();
		}
		//Exceptions for if the index is a lower number than 0
		else if (index < 0) {
			throw new IllegalArgumentException();
		}
		else
			return this.data[index];

	}

	public int[] getInnerArray() {
		//Will return an array of numbers that represents the binary number inputed
		return this.data;
	}

	public int toDecimal() {
		//Converts the binary number into the equivalent decimal value
		int t = 0;
		for(int i = 0; i < length; i++) {
			t += data[i] * Math.pow(2, length-1-i);
		}
		return t;
	}

	public void bitShift(int direction, int amount) {
		//Will shift the bits
		if(amount < 0) {
			//throws an error if the amount is less than 0
			throw new IllegalArgumentException();
		}
		if(direction == 1) {
			//Direction 1 and -1 will shift to the bits right and left
			length = length - amount;
			int[] x= new int[length];
			for(int i=0; i<length; i++){
				x[i]=this.getDigit(i);
			}
			data=x;
		}
		else if(direction==-1) {
			//Part 2. of shift
			int[] x= new int[length+amount];
			for(int i=0; i<length; i++) {
				x[i]=this.getDigit(i);
			}
			data=x;
				length+=amount;
		}
		else {
			//Shown if there's an input error
			System.out.println("Error: Not taken in as a direction or amount ");
		}
	}

	public static int[] bwor(BinaryNumber bn1, BinaryNumber bn2) {
		//Checks if lengths are not equal and throws and error if so
		if(bn1.getLength() != bn2.getLength()) {
			System.out.println("Error: Binary number must be the same length");
		}
		//computes the bitwise or of the two numbers
		int[] x2 = new int[bn1.getLength()];
		for(int i=0; i < bn1.getLength(); i++) {
			if(bn1.getDigit(i)==1) {
				x2[1]=1;
			}
			if(bn2.getDigit(i) == 1) {
				x2[i]= 1;
			}
			else {
				x2[i] = 0;
			}
		}
		return x2;
	}

	public static int[] bwand(BinaryNumber bn1, BinaryNumber bn2) {
		//throws error if the lengths are not the sme
		if(bn1.getLength() != bn2.getLength()) {
			System.out.println("Error: Must be the same length");
		}
		//computes the bitwise and of the two numbers
		int[] x3= new int[bn1.getLength()];
		for(int i=0; i< bn1.getLength();i++) {
			if((bn1.getDigit(i)+bn2.getDigit(i)) == 2) {
				x3[i]=1;
			}
			else {
				x3[i]=0;
			}
		}
		return x3;
	}

	public String toString() {
		String str="";
		for(int i=0; i<this.getLength(); i++) {
			str+=Integer.toString(this.getDigit(i));
		}
		return str;
	}

	public void add(BinaryNumber aBinaryNumber) {
		//adds binary numbers
		boolean carry = false;
		for(int i = length - 1; i >= 0; i--) {
			if(data[i] + aBinaryNumber.data[i] == 2) {
				if(carry) {
					data[i] = 1;
				}
				else {
					carry = true;
					data[i] = 0;
					}
			}
			else if(data[i] + aBinaryNumber.data[i] == 0) {
				if(carry) {
					carry = false;
					data[i] = 1;
				}
				else {
					data[i] = 0;
				}
			}
			else if (data[i] + aBinaryNumber.data[i] == 1) {
				if (carry) {
					data[i] = 0;
				}
				else {
					data[i] = 1;
				}
			}
		}

		if(carry) {
			int[] temp = new int[length + 1];
			for (int i = 0; i < length; i++)
				temp[i + 1] = data[i];
			temp[0] = 1;
			data = new int[length + 1];
			data = temp;
			length += 1;
		}

	}
	}
