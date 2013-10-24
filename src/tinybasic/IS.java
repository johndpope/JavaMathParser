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

public class IS {

	public int SIZE = 7;
	Instruction[] table;

	// Code of the instructions
	public final static int NOP = 0;
	public final static int LET = 1;
	public final static int LETI = 2;
	public final static int IF = 3;
	public final static int GOTO = 4;
	public final static int STOP = 5;
	public final static int PRINT = 6;

	// Code of the arithmetic operations
	public final static int ADD = 1;
	public final static int SUB = 2;
	public final static int MULT = 3;
	public final static int DIV = 4;

	public IS() {
		table = new Instruction[SIZE];

		table[NOP] = new Instruction("NOP", NOP, 0);
		table[LET] = new Instruction("LET", LET, 5);
		table[LETI] = new Instruction("LETI", LETI, 3);
		table[IF] = new Instruction("IF", IF, 2);
		table[GOTO] = new Instruction("GOTO", GOTO, 1);
		table[STOP] = new Instruction("STOP", STOP, 0);
		table[PRINT] = new Instruction("PRINT", PRINT, 1);

	}

	public boolean in_table(String inst_name) {
		for (int i = 0; i < table.length; i++) {
			if (table[i].name.compareToIgnoreCase(inst_name) == 0) {
				return true;
			}
		}
		return false;
	}

	public int get_op_code(String inst_name) {
		for (int i = 0; i < table.length; i++) {
			if (table[i].name.compareToIgnoreCase(inst_name) == 0) {
				return table[i].op_code;
			}
		}
		return -1;
	}

	public int get_args_num(int op_code) {
		return table[op_code].args;
	}

} // InstructionSet
