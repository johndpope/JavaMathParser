/*******************************************************************************
 * Copyright 2013 Robert Ying, based on code by Ernesto Tapias
 * 
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 * 
 *   http://www.apache.org/licenses/LICENSE-2.0
 * 
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 ******************************************************************************/
package tinybasic;

import java.io.*;
import java.util.*;

public class Main {

	public static void main(String[] args) {

		InputStreamReader isr = new InputStreamReader(System.in);
		BufferedReader br = new BufferedReader(isr);
		String line = "";
		IS instSet = new IS();
		ProgramMemory code = new ProgramMemory(instSet);
		String[] arguments = new String[6];

		while (true) {
			System.out.print(">");
			try {
				line = br.readLine();
			} catch (IOException ioe) {
				System.out.println(ioe.getMessage());
			}
			if (line.compareToIgnoreCase("RUN") == 0) {
				code.execute();
			} else if (line.compareToIgnoreCase("LIST") == 0) {
				code.list();
			} else {
				while (true) {
					StringTokenizer st = new StringTokenizer(line);
					String newToken = st.nextToken();
					int addr = 0;
					try {
						addr = Integer.parseInt(newToken);
					} catch (NumberFormatException nfe) {
						System.out.println("no line number: " + newToken);
						break;
					}

					int op_code = 0;
					newToken = st.nextToken();
					if (instSet.in_table(newToken)) {
						op_code = instSet.get_op_code(newToken);
						code.mem[addr][0] = op_code;
					} else {
						System.out
								.println("undefined instruction: " + newToken);
						break;
					}
					int number_of_args = instSet.get_args_num(op_code);
					if (number_of_args > 0) {
						for (int i = 1; i <= number_of_args; i++) {
							if (st.hasMoreElements()) {
								arguments[i] = st.nextToken();
							} else {
								System.out
										.println("illegal number of arguments");
								break;
							}
						} // for
						switch (op_code) {
						case IS.LET:
							code.mem[addr][1] = (arguments[1].charAt(0) - 64);
							if (arguments[4].compareTo("+") == 0) {
								code.mem[addr][2] = IS.ADD;
							}
							if (arguments[4].compareTo("-") == 0) {
								code.mem[addr][2] = IS.SUB;
							}
							if (arguments[4].compareTo("*") == 0) {
								code.mem[addr][2] = IS.MULT;
							}
							if (arguments[4].compareTo("/") == 0) {
								code.mem[addr][2] = IS.DIV;
							}
							code.mem[addr][3] = (arguments[3].charAt(0) - 64);
							code.mem[addr][4] = (arguments[5].charAt(0) - 64);
							;
							break;
						case IS.LETI:
							code.mem[addr][1] = (arguments[1].charAt(0) - 64);
							code.mem[addr][2] = Integer.parseInt(arguments[3]);
							;
							break;
						case IS.IF:
							code.mem[addr][1] = (arguments[1].charAt(0) - 64);
							code.mem[addr][2] = Integer.parseInt(arguments[2]);
							break;
						case IS.GOTO:
							code.mem[addr][1] = Integer.parseInt(arguments[1]);
							break;
						case IS.PRINT:
							code.mem[addr][1] = (arguments[1].charAt(0) - 64);
							break;

						}
					} // if
					break;
				} // while
			}
		} // main while
	} // main

	public static String interpret(String program) {
		IS instSet = new IS();
		ProgramMemory code = new ProgramMemory(instSet);
		String[] arguments = new String[6];
		String str = "";
		int k;

		StringTokenizer st = new StringTokenizer(program, "\n");
		String[] line = new String[st.countTokens()];

		for (int i = 0; i < line.length; i++) {
			line[i] = new String(st.nextToken());
		}

		for (k = 0; k < line.length; k++) {

			if (line[k].compareToIgnoreCase("RUN") == 0) {
				str += code.execute();
			} else if (line[k].compareToIgnoreCase("LIST") == 0) {
				str += code.list();
			} else {
				while (true) {
					st = new StringTokenizer(line[k]);
					String newToken = st.nextToken();
					int addr = 0;
					try {
						addr = Integer.parseInt(newToken);
					} catch (NumberFormatException nfe) {
						return ("[TinyBasic] no line number: " + newToken);
					}

					int op_code = 0;
					newToken = st.nextToken();
					if (instSet.in_table(newToken)) {
						op_code = instSet.get_op_code(newToken);
						code.mem[addr][0] = op_code;
					} else {
						return ("[TinyBasic] undefined instruction: " + newToken);
					}
					int number_of_args = instSet.get_args_num(op_code);
					if (number_of_args > 0) {
						for (int i = 1; i <= number_of_args; i++) {
							if (st.hasMoreElements()) {
								arguments[i] = st.nextToken();
							} else {
								return ("[TinyBasic] illegal number of arguments");
							}
						} // for
						switch (op_code) {
						case IS.LET:
							code.mem[addr][1] = (arguments[1].charAt(0) - 64);
							if (arguments[4].compareTo("+") == 0) {
								code.mem[addr][2] = IS.ADD;
							}
							if (arguments[4].compareTo("-") == 0) {
								code.mem[addr][2] = IS.SUB;
							}
							if (arguments[4].compareTo("*") == 0) {
								code.mem[addr][2] = IS.MULT;
							}
							if (arguments[4].compareTo("/") == 0) {
								code.mem[addr][2] = IS.DIV;
							}
							code.mem[addr][3] = (arguments[3].charAt(0) - 64);
							code.mem[addr][4] = (arguments[5].charAt(0) - 64);
							;
							break;
						case IS.LETI:
							code.mem[addr][1] = (arguments[1].charAt(0) - 64);
							code.mem[addr][2] = Integer.parseInt(arguments[3]);
							;
							break;
						case IS.IF:
							code.mem[addr][1] = (arguments[1].charAt(0) - 64);
							code.mem[addr][2] = Integer.parseInt(arguments[2]);
							break;
						case IS.GOTO:
							code.mem[addr][1] = Integer.parseInt(arguments[1]);
							break;
						case IS.PRINT:
							code.mem[addr][1] = (arguments[1].charAt(0) - 64);
							break;

						}
					} // if
					break;
				} // while
			}
		} // main while
		return str;
	} // main

} // end of Main class
