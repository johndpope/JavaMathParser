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
 * �berschrift: <p>
 * Beschreibung: <p>
 * Copyright: Copyright (c) <p>
 * Organisation: <p>
 * @author
 * @version 1.0
 */
package svm;

import java.util.*;
import java.io.*;

import ocr.*;

public class ReadUnipen {

	public static void main(String argv[]) throws Exception {
		BufferedReader filein;
		DataOutputStream fileout;
		String line;
		StringTokenizer st;
		ArrayList<Symbol> ArrayList;

		filein = new BufferedReader(new FileReader(argv[0]));
		fileout = new DataOutputStream(new FileOutputStream(argv[1]));

		filein.readLine();
		filein.readLine();
		filein.readLine();
		filein.readLine();
		filein.readLine();

		ArrayList = new ArrayList<Symbol>();
		int stTokens = 0;
		String header = null;
		Symbol symbol = null;
		DStroke stroke = null;
		int max = Integer.MIN_VALUE;
		// int min = Integer.MAX_VALUE;
		while ((line = filein.readLine()) != null) {
			st = new StringTokenizer(line, " ,?\"");

			stTokens = st.countTokens();

			if (stTokens == 0)
				continue;

			header = st.nextToken();

			if (header.equals(".SEGMENT")) {
				symbol = new Symbol();
				st.nextToken();
				st.nextToken();
				symbol.name = new String(st.nextToken());

				ArrayList.add(symbol);
			} else if (header.equals(".PEN_DOWN")) {
				stroke = new DStroke();
				symbol.add(stroke);
			} else if (header.equals(".PEN_UP") || header.equals(".DT")
					|| header.equals(".COMMENT")) {
				continue;
			} else {
				stroke.add(IO.atof(header), IO.atof(st.nextToken()));
				max = (int) Math.max(max, stroke.last().y);
			}
		}

		fileout.writeBytes(argv[1] + " 1\n");
		for (int i = 0; i < ArrayList.size(); i++) {
			fileout.writeBytes(ArrayList.get(i).name + " ");
		}
		fileout.writeBytes("\nGroup0\n");
		for (int i = 0; i < ArrayList.size(); i++) {
			symbol = ArrayList.get(i);
			fileout.writeBytes(symbol.name + " " + symbol.size() + "\n");
			for (int j = 0; j < symbol.size(); j++) {
				stroke = symbol.strokeAt(j);
				fileout.writeBytes(stroke.size() + " "
						+ System.currentTimeMillis() + " ");
				for (int k = 0; k < stroke.size(); k++) {
					fileout.writeBytes(" " + k + " " + stroke.pointAt(k).x
							+ " " + (max - stroke.pointAt(k).y));
				}
				fileout.writeBytes("\n");
			}
		}
		filein.close();
		fileout.close();
	}
}
