/**
 * Copyright (C) 2022-2023 Dominik Glaser
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package io.github.dogla.treetable;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

/**
 * Test class.
 *
 * @author Dominik Glaser
 */
@SuppressWarnings({ "nls", "javadoc" })
public class TreeTableTest {
	
	@Test
	public void test_string_constructor() {
	    TreeTable table = new TreeTable("User Name", "Salary", "Designation1", "Address", "Lucky#");
		table.addRow("Ram", "2000", "Manager", "#99, Silk board", "1111");
		table.addRow("Sri", "12000", "Developer", "BTM Layout", "22222");
		table.addRow("Prasad", "42000", "Lead", "#66, Viaya Bank Layout", "333333");
		table.addRow("Anu", "132000", "QA", "#22, Vizag", "4444444");
		table.addRow("Sai", "62000", "Developer", "#3-3, Kakinada");
		table.addRow("Venkat", "2000", "Manager");
		table.addRow("Raj", "62000");
		table.addRow("BTC");
		
		String expected = ""
				+ "+-----------+--------+--------------+------------------------+---------+\n"
				+ "| User Name | Salary | Designation1 | Address                | Lucky#  |\n"
				+ "+-----------+--------+--------------+------------------------+---------+\n"
				+ "| Ram       | 2000   | Manager      | #99, Silk board        | 1111    |\n"
				+ "| Sri       | 12000  | Developer    | BTM Layout             | 22222   |\n"
				+ "| Prasad    | 42000  | Lead         | #66, Viaya Bank Layout | 333333  |\n"
				+ "| Anu       | 132000 | QA           | #22, Vizag             | 4444444 |\n"
				+ "| Sai       | 62000  | Developer    | #3-3, Kakinada         |         |\n"
				+ "| Venkat    | 2000   | Manager      |                        |         |\n"
				+ "| Raj       | 62000  |              |                        |         |\n"
				+ "| BTC       |        |              |                        |         |\n"
				+ "+-----------+--------+--------------+------------------------+---------+\n"
				+ "";
		assertEquals(expected, table.toText());
	}

	
	@Test
	public void test_default_column_alignment() {
	    TreeTable table = new TreeTable(new Column[] {
    		new Column("User Name"),
    		new Column("Salary"),
    		new Column("Designation1"),
    		new Column("Address"),
    		new Column("Lucky#"),
	    });
		table.addRow("Ram", "2000", "Manager", "#99, Silk board", "1111");
		table.addRow("Sri", "12000", "Developer", "BTM Layout", "22222");
		table.addRow("Prasad", "42000", "Lead", "#66, Viaya Bank Layout", "333333");
		table.addRow("Anu", "132000", "QA", "#22, Vizag", "4444444");
		table.addRow("Sai", "62000", "Developer", "#3-3, Kakinada");
		table.addRow("Venkat", "2000", "Manager");
		table.addRow("Raj", "62000");
		table.addRow("BTC");
		
		String expected = ""
				+ "+-----------+--------+--------------+------------------------+---------+\n"
				+ "| User Name | Salary | Designation1 | Address                | Lucky#  |\n"
				+ "+-----------+--------+--------------+------------------------+---------+\n"
				+ "| Ram       | 2000   | Manager      | #99, Silk board        | 1111    |\n"
				+ "| Sri       | 12000  | Developer    | BTM Layout             | 22222   |\n"
				+ "| Prasad    | 42000  | Lead         | #66, Viaya Bank Layout | 333333  |\n"
				+ "| Anu       | 132000 | QA           | #22, Vizag             | 4444444 |\n"
				+ "| Sai       | 62000  | Developer    | #3-3, Kakinada         |         |\n"
				+ "| Venkat    | 2000   | Manager      |                        |         |\n"
				+ "| Raj       | 62000  |              |                        |         |\n"
				+ "| BTC       |        |              |                        |         |\n"
				+ "+-----------+--------+--------------+------------------------+---------+\n"
				+ "";
		assertEquals(expected, table.toText());
	}
	
	@Test
	public void test_custom_alignment_1() {
	    TreeTable table = new TreeTable(new Column[] {
    		new Column("User Name", ColumnAlignment.LEFT),
    		new Column("Salary", ColumnAlignment.RIGHT),
    		new Column("Designation1", ColumnAlignment.CENTER),
    		new Column("Address", ColumnAlignment.LEFT),
    		new Column("Lucky#", ColumnAlignment.RIGHT),
	    });
		table.addRow("Ram", "2000", "Manager", "#99, Silk board", "1111");
		table.addRow("Sri", "12000", "Developer", "BTM Layout", "22222");
		table.addRow("Prasad", "42000", "Lead", "#66, Viaya Bank Layout", "333333");
		table.addRow("Anu", "132000", "QA", "#22, Vizag", "4444444");
		table.addRow("Sai", "62000", "Developer", "#3-3, Kakinada");
		table.addRow("Venkat", "2000", "Manager");
		table.addRow("Raj", "62000");
		table.addRow("BTC");
		
		String expected = ""
				+ "+-----------+--------+--------------+------------------------+---------+\n"
				+ "| User Name | Salary | Designation1 | Address                |  Lucky# |\n"
				+ "+-----------+--------+--------------+------------------------+---------+\n"
				+ "| Ram       |   2000 |   Manager    | #99, Silk board        |    1111 |\n"
				+ "| Sri       |  12000 |  Developer   | BTM Layout             |   22222 |\n"
				+ "| Prasad    |  42000 |     Lead     | #66, Viaya Bank Layout |  333333 |\n"
				+ "| Anu       | 132000 |      QA      | #22, Vizag             | 4444444 |\n"
				+ "| Sai       |  62000 |  Developer   | #3-3, Kakinada         |         |\n"
				+ "| Venkat    |   2000 |   Manager    |                        |         |\n"
				+ "| Raj       |  62000 |              |                        |         |\n"
				+ "| BTC       |        |              |                        |         |\n"
				+ "+-----------+--------+--------------+------------------------+---------+\n"
				+ "";
		assertEquals(expected, table.toText());
	}

	@Test
	public void test_custom_alignment_2() {
	    TreeTable table = new TreeTable(new Column[] {
    		new Column("User Name", ColumnAlignment.LEFT),
    		new Column("Salary", ColumnAlignment.LEFT),
    		new Column("Designation1", ColumnAlignment.CENTER),
    		new Column("Address", ColumnAlignment.CENTER),
    		new Column("Lucky#", ColumnAlignment.CENTER),
	    });
		table.addRow("Ram", "2000", "Manager", "#99, Silk board", "1111");
		table.addRow("Sri", "12000", "Developer", "BTM Layout", "22222");
		table.addRow("Prasad", "42000", "Lead", "#66, Viaya Bank Layout", "333333");
		table.addRow("Anu", "132000", "QA", "#22, Vizag", "4444444");
		table.addRow("Sai", "62000", "Developer", "#3-3, Kakinada");
		table.addRow("Venkat", "2000", "Manager");
		table.addRow("Raj", "62000");
		table.addRow("BTC");
		
		String expected = ""
				+ "+-----------+--------+--------------+------------------------+---------+\n"
				+ "| User Name | Salary | Designation1 |        Address         | Lucky#  |\n"
				+ "+-----------+--------+--------------+------------------------+---------+\n"
				+ "| Ram       | 2000   |   Manager    |    #99, Silk board     |  1111   |\n"
				+ "| Sri       | 12000  |  Developer   |       BTM Layout       |  22222  |\n"
				+ "| Prasad    | 42000  |     Lead     | #66, Viaya Bank Layout | 333333  |\n"
				+ "| Anu       | 132000 |      QA      |       #22, Vizag       | 4444444 |\n"
				+ "| Sai       | 62000  |  Developer   |     #3-3, Kakinada     |         |\n"
				+ "| Venkat    | 2000   |   Manager    |                        |         |\n"
				+ "| Raj       | 62000  |              |                        |         |\n"
				+ "| BTC       |        |              |                        |         |\n"
				+ "+-----------+--------+--------------+------------------------+---------+\n"
				+ "";
		assertEquals(expected, table.toText());
	}

	@Test
	public void test_no_header() {
	    TreeTable table = new TreeTable(new Column[] {
    		new Column("User Name", ColumnAlignment.LEFT),
    		new Column("Salary", ColumnAlignment.LEFT),
    		new Column("Designation1", ColumnAlignment.CENTER),
    		new Column("Address", ColumnAlignment.CENTER),
    		new Column("Lucky#", ColumnAlignment.CENTER),
	    });
		table.addRow("Ram", "2000", "Manager", "#99, Silk board", "1111");
		table.addRow("Sri", "12000", "Developer", "BTM Layout", "22222");
		table.addRow("Prasad", "42000", "Lead", "#66, Viaya Bank Layout", "333333");
		table.addRow("Anu", "132000", "QA", "#22, Vizag", "4444444");
		table.addRow("Sai", "62000", "Developer", "#3-3, Kakinada");
		table.addRow("Venkat", "2000", "Manager");
		table.addRow("Raj", "62000");
		table.addRow("BTC");
		
		String expected = ""
				+ "+-----------+--------+--------------+------------------------+---------+\n"
				+ "| Ram       | 2000   |   Manager    |    #99, Silk board     |  1111   |\n"
				+ "| Sri       | 12000  |  Developer   |       BTM Layout       |  22222  |\n"
				+ "| Prasad    | 42000  |     Lead     | #66, Viaya Bank Layout | 333333  |\n"
				+ "| Anu       | 132000 |      QA      |       #22, Vizag       | 4444444 |\n"
				+ "| Sai       | 62000  |  Developer   |     #3-3, Kakinada     |         |\n"
				+ "| Venkat    | 2000   |   Manager    |                        |         |\n"
				+ "| Raj       | 62000  |              |                        |         |\n"
				+ "| BTC       |        |              |                        |         |\n"
				+ "+-----------+--------+--------------+------------------------+---------+\n"
				+ "";
		TreeTableToTextConverter converter = new TreeTableToTextConverter().withPrintHeader(false);
		assertEquals(expected, table.toText(converter));
		
		expected = ""
				+ "┌───────────┬────────┬──────────────┬────────────────────────┬─────────┐\n"
				+ "│ Ram       │ 2000   │   Manager    │    #99, Silk board     │  1111   │\n"
				+ "│ Sri       │ 12000  │  Developer   │       BTM Layout       │  22222  │\n"
				+ "│ Prasad    │ 42000  │     Lead     │ #66, Viaya Bank Layout │ 333333  │\n"
				+ "│ Anu       │ 132000 │      QA      │       #22, Vizag       │ 4444444 │\n"
				+ "│ Sai       │ 62000  │  Developer   │     #3-3, Kakinada     │         │\n"
				+ "│ Venkat    │ 2000   │   Manager    │                        │         │\n"
				+ "│ Raj       │ 62000  │              │                        │         │\n"
				+ "│ BTC       │        │              │                        │         │\n"
				+ "└───────────┴────────┴──────────────┴────────────────────────┴─────────┘\n"
				+ "";
		assertEquals(expected, table.toText(converter.withASCIIExtended()));		
	}
	
	@Test
	public void test_no_outerlines() {
	    TreeTable table = new TreeTable(new Column[] {
    		new Column("User Name", ColumnAlignment.LEFT),
    		new Column("Salary", ColumnAlignment.LEFT),
    		new Column("Designation1", ColumnAlignment.CENTER),
    		new Column("Address", ColumnAlignment.CENTER),
    		new Column("Lucky#", ColumnAlignment.CENTER),
	    });
		table.addRow("Ram", "2000", "Manager", "#99, Silk board", "1111");
		table.addRow("Sri", "12000", "Developer", "BTM Layout", "22222");
		table.addRow("Prasad", "42000", "Lead", "#66, Viaya Bank Layout", "333333");
		table.addRow("Anu", "132000", "QA", "#22, Vizag", "4444444");
		table.addRow("Sai", "62000", "Developer", "#3-3, Kakinada");
		table.addRow("Venkat", "2000", "Manager");
		table.addRow("Raj", "62000");
		table.addRow("BTC");
		
		String expected = ""
				+ "User Name | Salary | Designation1 |        Address         | Lucky# \n"
				+ "----------+--------+--------------+------------------------+--------\n"
				+ "Ram       | 2000   |   Manager    |    #99, Silk board     |  1111  \n"
				+ "Sri       | 12000  |  Developer   |       BTM Layout       |  22222 \n"
				+ "Prasad    | 42000  |     Lead     | #66, Viaya Bank Layout | 333333 \n"
				+ "Anu       | 132000 |      QA      |       #22, Vizag       | 4444444\n"
				+ "Sai       | 62000  |  Developer   |     #3-3, Kakinada     |        \n"
				+ "Venkat    | 2000   |   Manager    |                        |        \n"
				+ "Raj       | 62000  |              |                        |        \n"
				+ "BTC       |        |              |                        |        \n"
				+ "";
		TreeTableToTextConverter converter = new TreeTableToTextConverter().withPrintOuterLines(false);
		assertEquals(expected, table.toText(converter));
		
		expected = ""
				+ "User Name │ Salary │ Designation1 │        Address         │ Lucky# \n"
				+ "──────────┼────────┼──────────────┼────────────────────────┼────────\n"
				+ "Ram       │ 2000   │   Manager    │    #99, Silk board     │  1111  \n"
				+ "Sri       │ 12000  │  Developer   │       BTM Layout       │  22222 \n"
				+ "Prasad    │ 42000  │     Lead     │ #66, Viaya Bank Layout │ 333333 \n"
				+ "Anu       │ 132000 │      QA      │       #22, Vizag       │ 4444444\n"
				+ "Sai       │ 62000  │  Developer   │     #3-3, Kakinada     │        \n"
				+ "Venkat    │ 2000   │   Manager    │                        │        \n"
				+ "Raj       │ 62000  │              │                        │        \n"
				+ "BTC       │        │              │                        │        \n"
				+ "";
		assertEquals(expected, table.toText(converter.withASCIIExtended()));		
	}
	
	@Test
	public void test_no_header_no_outerlines() {
	    TreeTable table = new TreeTable(new Column[] {
    		new Column("User Name", ColumnAlignment.LEFT),
    		new Column("Salary", ColumnAlignment.LEFT),
    		new Column("Designation1", ColumnAlignment.CENTER),
    		new Column("Address", ColumnAlignment.CENTER),
    		new Column("Lucky#", ColumnAlignment.CENTER),
	    });
		table.addRow("Ram", "2000", "Manager", "#99, Silk board", "1111");
		table.addRow("Sri", "12000", "Developer", "BTM Layout", "22222");
		table.addRow("Prasad", "42000", "Lead", "#66, Viaya Bank Layout", "333333");
		table.addRow("Anu", "132000", "QA", "#22, Vizag", "4444444");
		table.addRow("Sai", "62000", "Developer", "#3-3, Kakinada");
		table.addRow("Venkat", "2000", "Manager");
		table.addRow("Raj", "62000");
		table.addRow("BTC");
		
		String expected = ""
				+ "Ram       | 2000   |   Manager    |    #99, Silk board     |  1111  \n"
				+ "Sri       | 12000  |  Developer   |       BTM Layout       |  22222 \n"
				+ "Prasad    | 42000  |     Lead     | #66, Viaya Bank Layout | 333333 \n"
				+ "Anu       | 132000 |      QA      |       #22, Vizag       | 4444444\n"
				+ "Sai       | 62000  |  Developer   |     #3-3, Kakinada     |        \n"
				+ "Venkat    | 2000   |   Manager    |                        |        \n"
				+ "Raj       | 62000  |              |                        |        \n"
				+ "BTC       |        |              |                        |        \n"
				+ "";
		TreeTableToTextConverter converter = new TreeTableToTextConverter().withPrintOuterLines(false).withPrintHeader(false);
		assertEquals(expected, table.toText(converter));
		
		expected = ""
				+ "Ram       │ 2000   │   Manager    │    #99, Silk board     │  1111  \n"
				+ "Sri       │ 12000  │  Developer   │       BTM Layout       │  22222 \n"
				+ "Prasad    │ 42000  │     Lead     │ #66, Viaya Bank Layout │ 333333 \n"
				+ "Anu       │ 132000 │      QA      │       #22, Vizag       │ 4444444\n"
				+ "Sai       │ 62000  │  Developer   │     #3-3, Kakinada     │        \n"
				+ "Venkat    │ 2000   │   Manager    │                        │        \n"
				+ "Raj       │ 62000  │              │                        │        \n"
				+ "BTC       │        │              │                        │        \n"
				+ "";
		assertEquals(expected, table.toText(converter.withASCIIExtended()));		
	}
	
	@Test
	public void test_no_innerlines() {
	    TreeTable table = new TreeTable(new Column[] {
    		new Column("User Name", ColumnAlignment.LEFT),
    		new Column("Salary", ColumnAlignment.LEFT),
    		new Column("Designation1", ColumnAlignment.CENTER),
    		new Column("Address", ColumnAlignment.CENTER),
    		new Column("Lucky#", ColumnAlignment.CENTER),
	    });
		table.addRow("Ram", "2000", "Manager", "#99, Silk board", "1111");
		table.addRow("Sri", "12000", "Developer", "BTM Layout", "22222");
		table.addRow("Prasad", "42000", "Lead", "#66, Viaya Bank Layout", "333333");
		table.addRow("Anu", "132000", "QA", "#22, Vizag", "4444444");
		table.addRow("Sai", "62000", "Developer", "#3-3, Kakinada");
		table.addRow("Venkat", "2000", "Manager");
		table.addRow("Raj", "62000");
		table.addRow("BTC");
		
		String expected = ""
				+ "+----------+------+------------+----------------------+--------+\n"
				+ "| User Name Salary Designation1        Address         Lucky#  |\n"
				+ "+----------+------+------------+----------------------+--------+\n"
				+ "| Ram       2000     Manager       #99, Silk board      1111   |\n"
				+ "| Sri       12000   Developer         BTM Layout        22222  |\n"
				+ "| Prasad    42000      Lead     #66, Viaya Bank Layout 333333  |\n"
				+ "| Anu       132000      QA            #22, Vizag       4444444 |\n"
				+ "| Sai       62000   Developer       #3-3, Kakinada             |\n"
				+ "| Venkat    2000     Manager                                   |\n"
				+ "| Raj       62000                                              |\n"
				+ "| BTC                                                          |\n"
				+ "+----------+------+------------+----------------------+--------+\n"
				+ "";
		TreeTableToTextConverter converter = new TreeTableToTextConverter().withPrintInnerLines(false);
		assertEquals(expected, table.toText(converter));
		
		expected = ""
				+ "┌──────────┬──────┬────────────┬──────────────────────┬────────┐\n"
				+ "│ User Name Salary Designation1        Address         Lucky#  │\n"
				+ "├──────────┼──────┼────────────┼──────────────────────┼────────┤\n"
				+ "│ Ram       2000     Manager       #99, Silk board      1111   │\n"
				+ "│ Sri       12000   Developer         BTM Layout        22222  │\n"
				+ "│ Prasad    42000      Lead     #66, Viaya Bank Layout 333333  │\n"
				+ "│ Anu       132000      QA            #22, Vizag       4444444 │\n"
				+ "│ Sai       62000   Developer       #3-3, Kakinada             │\n"
				+ "│ Venkat    2000     Manager                                   │\n"
				+ "│ Raj       62000                                              │\n"
				+ "│ BTC                                                          │\n"
				+ "└──────────┴──────┴────────────┴──────────────────────┴────────┘\n"
				+ "";
		assertEquals(expected, table.toText(converter.withASCIIExtended()));		
	}
	
	@Test
	public void test_no_header_no_innerlines() {
	    TreeTable table = new TreeTable(new Column[] {
    		new Column("User Name", ColumnAlignment.LEFT),
    		new Column("Salary", ColumnAlignment.LEFT),
    		new Column("Designation1", ColumnAlignment.CENTER),
    		new Column("Address", ColumnAlignment.CENTER),
    		new Column("Lucky#", ColumnAlignment.CENTER),
	    });
		table.addRow("Ram", "2000", "Manager", "#99, Silk board", "1111");
		table.addRow("Sri", "12000", "Developer", "BTM Layout", "22222");
		table.addRow("Prasad", "42000", "Lead", "#66, Viaya Bank Layout", "333333");
		table.addRow("Anu", "132000", "QA", "#22, Vizag", "4444444");
		table.addRow("Sai", "62000", "Developer", "#3-3, Kakinada");
		table.addRow("Venkat", "2000", "Manager");
		table.addRow("Raj", "62000");
		table.addRow("BTC");
		
		String expected = ""
				+ "+----------+------+------------+----------------------+--------+\n"
				+ "| Ram       2000     Manager       #99, Silk board      1111   |\n"
				+ "| Sri       12000   Developer         BTM Layout        22222  |\n"
				+ "| Prasad    42000      Lead     #66, Viaya Bank Layout 333333  |\n"
				+ "| Anu       132000      QA            #22, Vizag       4444444 |\n"
				+ "| Sai       62000   Developer       #3-3, Kakinada             |\n"
				+ "| Venkat    2000     Manager                                   |\n"
				+ "| Raj       62000                                              |\n"
				+ "| BTC                                                          |\n"
				+ "+----------+------+------------+----------------------+--------+\n"
				+ "";
		TreeTableToTextConverter converter = new TreeTableToTextConverter().withPrintInnerLines(false).withPrintHeader(false);
		assertEquals(expected, table.toText(converter));
		
		expected = ""
				+ "┌──────────┬──────┬────────────┬──────────────────────┬────────┐\n"
				+ "│ Ram       2000     Manager       #99, Silk board      1111   │\n"
				+ "│ Sri       12000   Developer         BTM Layout        22222  │\n"
				+ "│ Prasad    42000      Lead     #66, Viaya Bank Layout 333333  │\n"
				+ "│ Anu       132000      QA            #22, Vizag       4444444 │\n"
				+ "│ Sai       62000   Developer       #3-3, Kakinada             │\n"
				+ "│ Venkat    2000     Manager                                   │\n"
				+ "│ Raj       62000                                              │\n"
				+ "│ BTC                                                          │\n"
				+ "└──────────┴──────┴────────────┴──────────────────────┴────────┘\n"
				+ "";
		assertEquals(expected, table.toText(converter.withASCIIExtended()));		
	}
	
	@Test
	public void test_no_outerlines_no_innerlines() {
	    TreeTable table = new TreeTable(new Column[] {
    		new Column("User Name", ColumnAlignment.LEFT),
    		new Column("Salary", ColumnAlignment.LEFT),
    		new Column("Designation1", ColumnAlignment.CENTER),
    		new Column("Address", ColumnAlignment.CENTER),
    		new Column("Lucky#", ColumnAlignment.CENTER),
	    });
		table.addRow("Ram", "2000", "Manager", "#99, Silk board", "1111");
		table.addRow("Sri", "12000", "Developer", "BTM Layout", "22222");
		table.addRow("Prasad", "42000", "Lead", "#66, Viaya Bank Layout", "333333");
		table.addRow("Anu", "132000", "QA", "#22, Vizag", "4444444");
		table.addRow("Sai", "62000", "Developer", "#3-3, Kakinada");
		table.addRow("Venkat", "2000", "Manager");
		table.addRow("Raj", "62000");
		table.addRow("BTC");
		
		String expected = ""
				+ "User Name Salary Designation1        Address         Lucky# \n"
				+ "---------+------+------------+----------------------+-------\n"
				+ "Ram       2000     Manager       #99, Silk board      1111  \n"
				+ "Sri       12000   Developer         BTM Layout        22222 \n"
				+ "Prasad    42000      Lead     #66, Viaya Bank Layout 333333 \n"
				+ "Anu       132000      QA            #22, Vizag       4444444\n"
				+ "Sai       62000   Developer       #3-3, Kakinada            \n"
				+ "Venkat    2000     Manager                                  \n"
				+ "Raj       62000                                             \n"
				+ "BTC                                                         \n"
				+ "";
		TreeTableToTextConverter converter = new TreeTableToTextConverter().withPrintInnerLines(false).withPrintOuterLines(false);
		assertEquals(expected, table.toText(converter));
		
		expected = ""
				+ "User Name Salary Designation1        Address         Lucky# \n"
				+ "─────────┼──────┼────────────┼──────────────────────┼───────\n"
				+ "Ram       2000     Manager       #99, Silk board      1111  \n"
				+ "Sri       12000   Developer         BTM Layout        22222 \n"
				+ "Prasad    42000      Lead     #66, Viaya Bank Layout 333333 \n"
				+ "Anu       132000      QA            #22, Vizag       4444444\n"
				+ "Sai       62000   Developer       #3-3, Kakinada            \n"
				+ "Venkat    2000     Manager                                  \n"
				+ "Raj       62000                                             \n"
				+ "BTC                                                         \n"
				+ "";
		assertEquals(expected, table.toText(converter.withASCIIExtended()));		
	}
	
	@Test
	public void test_no_outerlines_no_innerlines_no_header() {
	    TreeTable table = new TreeTable(new Column[] {
    		new Column("User Name", ColumnAlignment.LEFT),
    		new Column("Salary", ColumnAlignment.LEFT),
    		new Column("Designation1", ColumnAlignment.CENTER),
    		new Column("Address", ColumnAlignment.CENTER),
    		new Column("Lucky#", ColumnAlignment.CENTER),
	    });
		table.addRow("Ram", "2000", "Manager", "#99, Silk board", "1111");
		table.addRow("Sri", "12000", "Developer", "BTM Layout", "22222");
		table.addRow("Prasad", "42000", "Lead", "#66, Viaya Bank Layout", "333333");
		table.addRow("Anu", "132000", "QA", "#22, Vizag", "4444444");
		table.addRow("Sai", "62000", "Developer", "#3-3, Kakinada");
		table.addRow("Venkat", "2000", "Manager");
		table.addRow("Raj", "62000");
		table.addRow("BTC");
		
		String expected = ""
				+ "Ram       2000     Manager       #99, Silk board      1111  \n"
				+ "Sri       12000   Developer         BTM Layout        22222 \n"
				+ "Prasad    42000      Lead     #66, Viaya Bank Layout 333333 \n"
				+ "Anu       132000      QA            #22, Vizag       4444444\n"
				+ "Sai       62000   Developer       #3-3, Kakinada            \n"
				+ "Venkat    2000     Manager                                  \n"
				+ "Raj       62000                                             \n"
				+ "BTC                                                         \n"
				+ "";
		TreeTableToTextConverter converter = new TreeTableToTextConverter().withPrintInnerLines(false).withPrintOuterLines(false).withPrintHeader(false);
		assertEquals(expected, table.toText(converter));
		
		expected = ""
				+ "Ram       2000     Manager       #99, Silk board      1111  \n"
				+ "Sri       12000   Developer         BTM Layout        22222 \n"
				+ "Prasad    42000      Lead     #66, Viaya Bank Layout 333333 \n"
				+ "Anu       132000      QA            #22, Vizag       4444444\n"
				+ "Sai       62000   Developer       #3-3, Kakinada            \n"
				+ "Venkat    2000     Manager                                  \n"
				+ "Raj       62000                                             \n"
				+ "BTC                                                         \n"
				+ "";
		assertEquals(expected, table.toText(converter.withASCIIExtended()));		
	}
	
	@Test
	public void test_tree() {
	    TreeTable tree = new TreeTable(new Column[] {
    		new Column("File", ColumnAlignment.RIGHT),
    		new Column("Date", ColumnAlignment.RIGHT),
    		new Column("Size", ColumnAlignment.RIGHT),
	    });
	    Row c = tree.addRow("C:");
	    Row windows = c.addRow("Windows");
	    c.addRow("hiberfil.sys", "01.01.2015", "13.460.758");
	    c.addRow("pagefile.sys", "01.01.2015", "4.112.754");
	    c.addRow("swapfile.sys", "01.01.2015", "4.152");
	    windows.addRow("explorer.exe", "20.11.2014", "4.800");
	    windows.addRow("regedit.exe", "17.09.2014", "360");

	    Row windowsOld = c.addRow("Windows.old");
	    windowsOld.addRow("explorer.exe", "20.11.2014", "4.800");
	    windowsOld.addRow("regedit.exe", "17.09.2014", "360");
	    
	    Row d = tree.addRow("D:");
	    Row documents = d.addRow("Documents");
	    d.addRow("test.png", "01.01.2015", "13.460.758");
	    d.addRow("sample.html", "01.01.2015", "4.112.754");
	    d.addRow("todo.txt", "01.01.2015", "4.152");
	    documents.addRow("todo.docx", "20.11.2014", "4.800");
	    documents.addRow("charts.xlsx", "17.09.2014", "360");
	    
		String expected = ""
				+ "+---------------------+------------+------------+\n"
				+ "| File                |       Date |       Size |\n"
				+ "+---------------------+------------+------------+\n"
				+ "| C:                  |            |            |\n"
				+ "| +-- Windows         |            |            |\n"
				+ "| |  +-- explorer.exe | 20.11.2014 |      4.800 |\n"
				+ "| |  +-- regedit.exe  | 17.09.2014 |        360 |\n"
				+ "| +-- Windows.old     |            |            |\n"
				+ "| |  +-- explorer.exe | 20.11.2014 |      4.800 |\n"
				+ "| |  +-- regedit.exe  | 17.09.2014 |        360 |\n"
				+ "| +-- hiberfil.sys    | 01.01.2015 | 13.460.758 |\n"
				+ "| +-- pagefile.sys    | 01.01.2015 |  4.112.754 |\n"
				+ "| +-- swapfile.sys    | 01.01.2015 |      4.152 |\n"
				+ "| D:                  |            |            |\n"
				+ "| +-- Documents       |            |            |\n"
				+ "| |  +-- todo.docx    | 20.11.2014 |      4.800 |\n"
				+ "| |  +-- charts.xlsx  | 17.09.2014 |        360 |\n"
				+ "| +-- test.png        | 01.01.2015 | 13.460.758 |\n"
				+ "| +-- sample.html     | 01.01.2015 |  4.112.754 |\n"
				+ "| +-- todo.txt        | 01.01.2015 |      4.152 |\n"
				+ "+---------------------+------------+------------+\n"
				+ "";
		assertEquals(expected, tree.toText());
		
		expected = ""
				+ "┌─────────────────────┬────────────┬────────────┐\n"
				+ "│ File                │       Date │       Size │\n"
				+ "├─────────────────────┼────────────┼────────────┤\n"
				+ "│ C:                  │            │            │\n"
				+ "│ ├── Windows         │            │            │\n"
				+ "│ │  ├── explorer.exe │ 20.11.2014 │      4.800 │\n"
				+ "│ │  └── regedit.exe  │ 17.09.2014 │        360 │\n"
				+ "│ ├── Windows.old     │            │            │\n"
				+ "│ │  ├── explorer.exe │ 20.11.2014 │      4.800 │\n"
				+ "│ │  └── regedit.exe  │ 17.09.2014 │        360 │\n"
				+ "│ ├── hiberfil.sys    │ 01.01.2015 │ 13.460.758 │\n"
				+ "│ ├── pagefile.sys    │ 01.01.2015 │  4.112.754 │\n"
				+ "│ └── swapfile.sys    │ 01.01.2015 │      4.152 │\n"
				+ "│ D:                  │            │            │\n"
				+ "│ ├── Documents       │            │            │\n"
				+ "│ │  ├── todo.docx    │ 20.11.2014 │      4.800 │\n"
				+ "│ │  └── charts.xlsx  │ 17.09.2014 │        360 │\n"
				+ "│ ├── test.png        │ 01.01.2015 │ 13.460.758 │\n"
				+ "│ ├── sample.html     │ 01.01.2015 │  4.112.754 │\n"
				+ "│ └── todo.txt        │ 01.01.2015 │      4.152 │\n"
				+ "└─────────────────────┴────────────┴────────────┘\n"
				+ "";
		assertEquals(expected, tree.toText(new TreeTableToTextConverter().withASCIIExtended()));		
	}

	@Test
	public void test_tree_no_inner() {
	    TreeTable tree = new TreeTable(new Column[] {
    		new Column("File", ColumnAlignment.RIGHT),
    		new Column("Date", ColumnAlignment.RIGHT),
    		new Column("Size", ColumnAlignment.RIGHT),
	    });
	    Row c = tree.addRow("C:");
	    Row windows = c.addRow("Windows");
	    c.addRow("hiberfil.sys", "01.01.2015", "13.460.758");
	    c.addRow("pagefile.sys", "01.01.2015", "4.112.754");
	    c.addRow("swapfile.sys", "01.01.2015", "4.152");
	    windows.addRow("explorer.exe", "20.11.2014", "4.800");
	    windows.addRow("regedit.exe", "17.09.2014", "360");

	    Row windowsOld = c.addRow("Windows.old");
	    windowsOld.addRow("explorer.exe", "20.11.2014", "4.800");
	    windowsOld.addRow("regedit.exe", "17.09.2014", "360");
	    
	    Row d = tree.addRow("D:");
	    Row documents = d.addRow("Documents");
	    d.addRow("test.png", "01.01.2015", "13.460.758");
	    d.addRow("sample.html", "01.01.2015", "4.112.754");
	    d.addRow("todo.txt", "01.01.2015", "4.152");
	    documents.addRow("todo.docx", "20.11.2014", "4.800");
	    documents.addRow("charts.xlsx", "17.09.2014", "360");
	    
		String expected = ""
				+ "+--------------------+----------+-----------+\n"
				+ "| File                      Date       Size |\n"
				+ "+--------------------+----------+-----------+\n"
				+ "| C:                                        |\n"
				+ "| +-- Windows                               |\n"
				+ "| |  +-- explorer.exe 20.11.2014      4.800 |\n"
				+ "| |  +-- regedit.exe  17.09.2014        360 |\n"
				+ "| +-- Windows.old                           |\n"
				+ "| |  +-- explorer.exe 20.11.2014      4.800 |\n"
				+ "| |  +-- regedit.exe  17.09.2014        360 |\n"
				+ "| +-- hiberfil.sys    01.01.2015 13.460.758 |\n"
				+ "| +-- pagefile.sys    01.01.2015  4.112.754 |\n"
				+ "| +-- swapfile.sys    01.01.2015      4.152 |\n"
				+ "| D:                                        |\n"
				+ "| +-- Documents                             |\n"
				+ "| |  +-- todo.docx    20.11.2014      4.800 |\n"
				+ "| |  +-- charts.xlsx  17.09.2014        360 |\n"
				+ "| +-- test.png        01.01.2015 13.460.758 |\n"
				+ "| +-- sample.html     01.01.2015  4.112.754 |\n"
				+ "| +-- todo.txt        01.01.2015      4.152 |\n"
				+ "+--------------------+----------+-----------+\n"
				+ "";
		TreeTableToTextConverter converter = new TreeTableToTextConverter().withPrintInnerLines(false);
		assertEquals(expected, tree.toText(converter));
		
		expected = ""
				+ "┌────────────────────┬──────────┬───────────┐\n"
				+ "│ File                      Date       Size │\n"
				+ "├────────────────────┼──────────┼───────────┤\n"
				+ "│ C:                                        │\n"
				+ "│ ├── Windows                               │\n"
				+ "│ │  ├── explorer.exe 20.11.2014      4.800 │\n"
				+ "│ │  └── regedit.exe  17.09.2014        360 │\n"
				+ "│ ├── Windows.old                           │\n"
				+ "│ │  ├── explorer.exe 20.11.2014      4.800 │\n"
				+ "│ │  └── regedit.exe  17.09.2014        360 │\n"
				+ "│ ├── hiberfil.sys    01.01.2015 13.460.758 │\n"
				+ "│ ├── pagefile.sys    01.01.2015  4.112.754 │\n"
				+ "│ └── swapfile.sys    01.01.2015      4.152 │\n"
				+ "│ D:                                        │\n"
				+ "│ ├── Documents                             │\n"
				+ "│ │  ├── todo.docx    20.11.2014      4.800 │\n"
				+ "│ │  └── charts.xlsx  17.09.2014        360 │\n"
				+ "│ ├── test.png        01.01.2015 13.460.758 │\n"
				+ "│ ├── sample.html     01.01.2015  4.112.754 │\n"
				+ "│ └── todo.txt        01.01.2015      4.152 │\n"
				+ "└────────────────────┴──────────┴───────────┘\n"
				+ "";
		assertEquals(expected, tree.toText(converter.withASCIIExtended()));		
	}

	@Test
	public void test_tree_no_outer() {
	    TreeTable tree = new TreeTable(new Column[] {
    		new Column("File", ColumnAlignment.RIGHT),
    		new Column("Date", ColumnAlignment.RIGHT),
    		new Column("Size", ColumnAlignment.RIGHT),
	    });
	    Row c = tree.addRow("C:");
	    Row windows = c.addRow("Windows");
	    c.addRow("hiberfil.sys", "01.01.2015", "13.460.758");
	    c.addRow("pagefile.sys", "01.01.2015", "4.112.754");
	    c.addRow("swapfile.sys", "01.01.2015", "4.152");
	    windows.addRow("explorer.exe", "20.11.2014", "4.800");
	    windows.addRow("regedit.exe", "17.09.2014", "360");

	    Row windowsOld = c.addRow("Windows.old");
	    windowsOld.addRow("explorer.exe", "20.11.2014", "4.800");
	    windowsOld.addRow("regedit.exe", "17.09.2014", "360");
	    
	    Row d = tree.addRow("D:");
	    Row documents = d.addRow("Documents");
	    d.addRow("test.png", "01.01.2015", "13.460.758");
	    d.addRow("sample.html", "01.01.2015", "4.112.754");
	    d.addRow("todo.txt", "01.01.2015", "4.152");
	    documents.addRow("todo.docx", "20.11.2014", "4.800");
	    documents.addRow("charts.xlsx", "17.09.2014", "360");
	    
		String expected = ""
				+ "File                |       Date |       Size\n"
				+ "--------------------+------------+-----------\n"
				+ "C:                  |            |           \n"
				+ "+-- Windows         |            |           \n"
				+ "|  +-- explorer.exe | 20.11.2014 |      4.800\n"
				+ "|  +-- regedit.exe  | 17.09.2014 |        360\n"
				+ "+-- Windows.old     |            |           \n"
				+ "|  +-- explorer.exe | 20.11.2014 |      4.800\n"
				+ "|  +-- regedit.exe  | 17.09.2014 |        360\n"
				+ "+-- hiberfil.sys    | 01.01.2015 | 13.460.758\n"
				+ "+-- pagefile.sys    | 01.01.2015 |  4.112.754\n"
				+ "+-- swapfile.sys    | 01.01.2015 |      4.152\n"
				+ "D:                  |            |           \n"
				+ "+-- Documents       |            |           \n"
				+ "|  +-- todo.docx    | 20.11.2014 |      4.800\n"
				+ "|  +-- charts.xlsx  | 17.09.2014 |        360\n"
				+ "+-- test.png        | 01.01.2015 | 13.460.758\n"
				+ "+-- sample.html     | 01.01.2015 |  4.112.754\n"
				+ "+-- todo.txt        | 01.01.2015 |      4.152\n"
				+ "";
		TreeTableToTextConverter converter = new TreeTableToTextConverter().withPrintOuterLines(false);
		assertEquals(expected, tree.toText(converter));
		
		expected = ""
				+ "File                │       Date │       Size\n"
				+ "────────────────────┼────────────┼───────────\n"
				+ "C:                  │            │           \n"
				+ "├── Windows         │            │           \n"
				+ "│  ├── explorer.exe │ 20.11.2014 │      4.800\n"
				+ "│  └── regedit.exe  │ 17.09.2014 │        360\n"
				+ "├── Windows.old     │            │           \n"
				+ "│  ├── explorer.exe │ 20.11.2014 │      4.800\n"
				+ "│  └── regedit.exe  │ 17.09.2014 │        360\n"
				+ "├── hiberfil.sys    │ 01.01.2015 │ 13.460.758\n"
				+ "├── pagefile.sys    │ 01.01.2015 │  4.112.754\n"
				+ "└── swapfile.sys    │ 01.01.2015 │      4.152\n"
				+ "D:                  │            │           \n"
				+ "├── Documents       │            │           \n"
				+ "│  ├── todo.docx    │ 20.11.2014 │      4.800\n"
				+ "│  └── charts.xlsx  │ 17.09.2014 │        360\n"
				+ "├── test.png        │ 01.01.2015 │ 13.460.758\n"
				+ "├── sample.html     │ 01.01.2015 │  4.112.754\n"
				+ "└── todo.txt        │ 01.01.2015 │      4.152\n"
				+ "";
		assertEquals(expected, tree.toText(converter.withASCIIExtended()));		
	}	
	
	@Test
	public void test_tree_levels() {
	    TreeTable tree = new TreeTable(new Column[] {
    		new Column("Level", ColumnAlignment.RIGHT),
	    });
	    Row one = tree.addRow("one");
		Row three = one.addRow("two").addRow("three");
		Row four = three.addRow("four");
		four.addRow("five").addRow("six");
		one.addRow("baz");
		three.addRow("bar");
		four.addRow("foo");
		
		String expected = ""
				+ "+----------------------+\n"
				+ "| Level                |\n"
				+ "+----------------------+\n"
				+ "| one                  |\n"
				+ "| +-- two              |\n"
				+ "| |  +-- three         |\n"
				+ "| |      +-- four      |\n"
				+ "| |      |  +-- five   |\n"
				+ "| |      |  |  +-- six |\n"
				+ "| |      |  +-- foo    |\n"
				+ "| |      +-- bar       |\n"
				+ "| +-- baz              |\n"
				+ "+----------------------+\n"
				+ "";
		assertEquals(expected, tree.toText());
		
		expected = ""
				+ "┌──────────────────────┐\n"
				+ "│ Level                │\n"
				+ "├──────────────────────┤\n"
				+ "│ one                  │\n"
				+ "│ ├── two              │\n"
				+ "│ │  └── three         │\n"
				+ "│ │      ├── four      │\n"
				+ "│ │      │  ├── five   │\n"
				+ "│ │      │  │  └── six │\n"
				+ "│ │      │  └── foo    │\n"
				+ "│ │      └── bar       │\n"
				+ "│ └── baz              │\n"
				+ "└──────────────────────┘\n"
				+ "";
		assertEquals(expected, tree.toText(new TreeTableToTextConverter().withASCIIExtended()));		
	}
	
	@Test
	public void test_tree_levels_no_header_no_inner_no_outer() {
	    TreeTable tree = new TreeTable(new Column[] {
    		new Column("Level", ColumnAlignment.RIGHT),
	    });
	    Row one = tree.addRow("one");
		Row three = one.addRow("two").addRow("three");
		Row four = three.addRow("four");
		four.addRow("five").addRow("six");
		one.addRow("baz");
		three.addRow("bar");
		four.addRow("foo");
		
		String expected = ""
				+ "one                 \n"
				+ "+-- two             \n"
				+ "|  +-- three        \n"
				+ "|      +-- four     \n"
				+ "|      |  +-- five  \n"
				+ "|      |  |  +-- six\n"
				+ "|      |  +-- foo   \n"
				+ "|      +-- bar      \n"
				+ "+-- baz             \n"
				+ "";
		TreeTableToTextConverter converter = new TreeTableToTextConverter().withPrintInnerLines(false).withPrintOuterLines(false).withPrintHeader(false);
		assertEquals(expected, tree.toText(converter));
		
		expected = ""
				+ "one                 \n"
				+ "├── two             \n"
				+ "│  └── three        \n"
				+ "│      ├── four     \n"
				+ "│      │  ├── five  \n"
				+ "│      │  │  └── six\n"
				+ "│      │  └── foo   \n"
				+ "│      └── bar      \n"
				+ "└── baz             \n"
				+ "";
		assertEquals(expected, tree.toText(converter.withASCIIExtended()));		
	}
	
}
