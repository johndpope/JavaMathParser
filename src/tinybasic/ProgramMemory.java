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
/**
 * @version 1.0
 */
package tinybasic;

import java.util.*;
import javax.swing.*;

public class ProgramMemory {
	public static JTextArea ta = null;
	public int[][] mem;
	private int[] vars;
	private int pc;
	private IS instSet;
	private String temp;

	// Maximum program lines und size of a program line
	public final int MAX_PROG_SIZE = 10;
	public final int PROG_LINE_SIZE = 5;

	// Object constructor initializes memory to zeroes

	public ProgramMemory(IS instSet) {
		this.instSet = instSet;
		mem = new int[MAX_PROG_SIZE][PROG_LINE_SIZE];
		for (int i = 0; i < MAX_PROG_SIZE; i++) {
			for (int j = 0; j < PROG_LINE_SIZE; j++) {
				mem[i][j] = 0;
			}
		}
		vars = new int[27];
		for (int i = 0; i < 27; i++) {
			vars[i] = 0;
		}
	}

	// Execution of the GOTO

	public int go_to(int[] line) {
		return line[1];
	}

	// execution of IF
	// IF variable >=0 execution continues at new line

	public int if_test(int[] line) {
		if (vars[line[1]] >= 0) {
			return line[2];
		} else {
			return pc + 1;
		}
	}

	// execution of LET

	public void let(int[] line) {
		switch (line[2]) {
		case IS.ADD:
			vars[line[1]] = vars[line[3]] + vars[line[4]];
			break;
		case IS.SUB:
			vars[line[1]] = vars[line[3]] - vars[line[4]];
			break;
		case IS.MULT:
			vars[line[1]] = vars[line[3]] * vars[line[4]];
			break;
		case IS.DIV:
			vars[line[1]] = vars[line[3]] / vars[line[4]];
			break;
		} // switch
	}

	// execution of LETI

	public void leti(int[] line) {
		vars[line[1]] = line[2];
	}

	// main execution loop
	// execution starts at line number 0

	public String execute() {
		boolean executing = true;
		String str = "";
		pc = 0;
		while (executing) {
			int[] line = mem[pc];
			switch (line[0]) {
			case IS.NOP:
				pc++;
				break;
			case IS.LET:
				let(line);
				pc++;
				break;
			case IS.LETI:
				leti(line);
				pc++;
				break;
			case IS.IF:
				pc = if_test(line);
				break;
			case IS.GOTO:
				pc = go_to(line);
				break;
			case IS.STOP:
				executing = false;
				break;
			case IS.PRINT:
				System.out.println(vars[line[1]]);
				ta.append("" + vars[line[1]]);
				pc++;
				break;
			} // case
			if (pc >= MAX_PROG_SIZE) {
				return "vars[line[1]]";
			}
		} // while

		return str;
	} // run

	// method for listing a program

	public String list() {
		String str = "";

		for (int i = 0; i < MAX_PROG_SIZE; i++) {
			if (mem[i][0] > IS.NOP) {
				System.out.print(i + ":\t");
				ta.append(i + ":\t");
				System.out.print(instSet.table[mem[i][0]].name + "  ");
				ta.append(instSet.table[mem[i][0]].name + "  ");
				switch (mem[i][0]) {
				case IS.NOP:
					;
					break;
				case IS.STOP:
					;
					break;
				case IS.IF:
					System.out.print(((char) (mem[i][1] + 64)) + " THEN "
							+ mem[i][2]);
					ta.append(((char) (mem[i][1] + 64)) + " THEN " + mem[i][2]);
					break;
				case IS.GOTO:
					System.out.print(mem[i][1]);
					ta.append("" + mem[i][1]);
					break;
				case IS.PRINT:
					System.out.print(((char) (mem[i][1] + 64)));
					ta.append("" + ((char) (mem[i][1] + 64)));
					break;
				case IS.LETI:
					System.out.print(((char) (mem[i][1] + 64)) + " = "
							+ mem[i][2]);
					ta.append(((char) (mem[i][1] + 64)) + " = " + mem[i][2]);
					break;
				case IS.LET:
					switch (mem[i][2]) {
					case IS.ADD:
						temp = "+";
						break;
					case IS.SUB:
						temp = "-";
						break;
					case IS.MULT:
						temp = "*";
						break;
					case IS.DIV:
						temp = "/";
						break;
					}

					System.out.print(((char) (mem[i][1] + 64)) + " = "
							+ ((char) (mem[i][3] + 64)) + " " + temp + " "
							+ ((char) (mem[i][4] + 64)));
					ta.append(((char) (mem[i][1] + 64)) + " = "
							+ ((char) (mem[i][3] + 64)) + " " + temp + " "
							+ ((char) (mem[i][4] + 64)));
					break;
				default:
					break;
				}
				System.out.println();
				ta.append("\n");
			}
		}

		return str;
	}

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
				code.execute();
			} else if (line[k].compareToIgnoreCase("LIST") == 0) {
				code.list();
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

} // end for ProgramMemory
