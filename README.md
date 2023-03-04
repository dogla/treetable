# TreeTable

A small library for table or tree like structures with column support. The model can be easily used to convert table and tree structures with columns to their corresponding ASCII based text representation.

## Dependencies

- Java 11
- no further Java libs

## Setup

To use this library you can use the corresponding maven dependency:

```xml
    <dependency>
        <groupId>io.github.dogla</groupId>
        <artifactId>treetable</artifactId>
        <version>1.0.0</version>
    <dependency>
```

## Usage

### No Customizations

```java
TreeTable table = new TreeTable("ID", "Name", "EMail", "Phone", "Company", "Salara");
table.addRow("1", "Leanne Graham", "Sincere@april.biz", "1-770-736-8031 x56442", "Romaguera-Crona", 3200);
table.addRow("2", "Ervin Howell", "Shanna@melissa.tv", "010-692-6593 x09125", "Deckow-Crist", 899);
table.addRow("3", "Clementine Bauch", "Nathan@yesenia.net", "1-463-123-4447", "Romaguera-Jacobson", 99);
table.addRow("4", "Patricia Lebsack");
System.out.println(table);
// same as System.out.println(table.toText());
// same as System.out.println(table.toText(new TreeTableToTextConverter());
```

Console:

```text
+----+------------------+--------------------+-----------------------+--------------------+--------+
| ID | Name             | EMail              | Phone                 | Company            | Salary |
+----+------------------+--------------------+-----------------------+--------------------+--------+
| 1  | Leanne Graham    | Sincere@april.biz  | 1-770-736-8031 x56442 | Romaguera-Crona    | 3200   |
| 2  | Ervin Howell     | Shanna@melissa.tv  | 010-692-6593 x09125   | Deckow-Crist       | 899    |
| 3  | Clementine Bauch | Nathan@yesenia.net | 1-463-123-4447        | Romaguera-Jacobson | 99     |
| 4  | Patricia Lebsack |                    |                       |                    |        |
+----+------------------+--------------------+-----------------------+--------------------+--------+
```

### Column Alignment

```java
TreeTable table = new TreeTable(new Column[] {
    new Column("ID"),
    new Column("Name"),
    new Column("EMail"),
    new Column("Phone"),
    new Column("Company", ColumnAlignment.CENTER),
    new Column("Salary", ColumnAlignment.RIGHT),
});

table.addRow("1", "Leanne Graham", "Sincere@april.biz", "1-770-736-8031 x56442", "Romaguera-Crona", 3200);
table.addRow("2", "Ervin Howell", "Shanna@melissa.tv", "010-692-6593 x09125", "Deckow-Crist", 899);
table.addRow("3", "Clementine Bauch", "Nathan@yesenia.net", "1-463-123-4447", "Romaguera-Jacobson", 99);
table.addRow("4", "Patricia Lebsack");
System.out.println(table); 
// same as System.out.println(table.toText());
// same as System.out.println(table.toText(new TreeTableToTextConverter());
```

Console:

```text
+----+------------------+--------------------+-----------------------+--------------------+--------+
| ID | Name             | EMail              | Phone                 |      Company       | Salary |
+----+------------------+--------------------+-----------------------+--------------------+--------+
| 1  | Leanne Graham    | Sincere@april.biz  | 1-770-736-8031 x56442 |  Romaguera-Crona   |   3200 |
| 2  | Ervin Howell     | Shanna@melissa.tv  | 010-692-6593 x09125   |    Deckow-Crist    |    899 |
| 3  | Clementine Bauch | Nathan@yesenia.net | 1-463-123-4447        | Romaguera-Jacobson |     99 |
| 4  | Patricia Lebsack |                    |                       |                    |        |
+----+------------------+--------------------+-----------------------+--------------------+--------+
```

## Extended Usage (with TreeTableToTextConverter)

### No Header

```java
/* [...] */
TreeTableToTextConverter toTextConverter = new TreeTableToTextConverter()
    .withPrintHeader(false);
System.out.println(table.toText(toTextConverter));
```

Console:

```text
+----+------------------+--------------------+-----------------------+--------------------+--------+
| 1  | Leanne Graham    | Sincere@april.biz  | 1-770-736-8031 x56442 |  Romaguera-Crona   |   3200 |
| 2  | Ervin Howell     | Shanna@melissa.tv  | 010-692-6593 x09125   |    Deckow-Crist    |    899 |
| 3  | Clementine Bauch | Nathan@yesenia.net | 1-463-123-4447        | Romaguera-Jacobson |     99 |
| 4  | Patricia Lebsack |                    |                       |                    |        |
+----+------------------+--------------------+-----------------------+--------------------+--------+
```

### Extended ASCII Lines

```java
/* [...] */
TreeTableToTextConverter toTextConverter = new TreeTableToTextConverter()
    .withASCIIExtended();
System.out.println(table.toText(toTextConverter));
```

Console:

```text
┌────┬──────────────────┬────────────────────┬───────────────────────┬────────────────────┬────────┐
│ ID │ Name             │ EMail              │ Phone                 │      Company       │ Salary │
├────┼──────────────────┼────────────────────┼───────────────────────┼────────────────────┼────────┤
│ 1  │ Leanne Graham    │ Sincere@april.biz  │ 1-770-736-8031 x56442 │  Romaguera-Crona   │   3200 │
│ 2  │ Ervin Howell     │ Shanna@melissa.tv  │ 010-692-6593 x09125   │    Deckow-Crist    │    899 │
│ 3  │ Clementine Bauch │ Nathan@yesenia.net │ 1-463-123-4447        │ Romaguera-Jacobson │     99 │
│ 4  │ Patricia Lebsack │                    │                       │                    │        │
└────┴──────────────────┴────────────────────┴───────────────────────┴────────────────────┴────────┘
```

### No Outer Lines

```java
/* [...] */
TreeTableToTextConverter toTextConverter = new TreeTableToTextConverter()
    .withPrintOuterLines(false);
System.out.println(table.toText(toTextConverter));
```

Console:

```text
ID | Name             | EMail              | Phone                 |      Company       | Salary
---+------------------+--------------------+-----------------------+--------------------+-------
1  | Leanne Graham    | Sincere@april.biz  | 1-770-736-8031 x56442 |  Romaguera-Crona   |   3200
2  | Ervin Howell     | Shanna@melissa.tv  | 010-692-6593 x09125   |    Deckow-Crist    |    899
3  | Clementine Bauch | Nathan@yesenia.net | 1-463-123-4447        | Romaguera-Jacobson |     99
4  | Patricia Lebsack |                    |                       |                    |       
```

### Extended ASCII Lines And No Outer Lines

```java
/* [...] */
TreeTableToTextConverter toTextConverter = new TreeTableToTextConverter()
    .withPrintOuterLines(false)
    .withASCIIExtended();
System.out.println(table.toText(toTextConverter));
```

Console:

```text
ID │ Name             │ EMail              │ Phone                 │      Company       │ Salary
───┼──────────────────┼────────────────────┼───────────────────────┼────────────────────┼───────
1  │ Leanne Graham    │ Sincere@april.biz  │ 1-770-736-8031 x56442 │  Romaguera-Crona   │   3200
2  │ Ervin Howell     │ Shanna@melissa.tv  │ 010-692-6593 x09125   │    Deckow-Crist    │    899
3  │ Clementine Bauch │ Nathan@yesenia.net │ 1-463-123-4447        │ Romaguera-Jacobson │     99
4  │ Patricia Lebsack │                    │                       │                    │       
```

### No Inner Lines

```java
/* [...] */
TreeTableToTextConverter toTextConverter = new TreeTableToTextConverter()
    .withPrintInnerLines(false);
System.out.println(table.toText(toTextConverter));
```

Console:

```text
+---+----------------+------------------+---------------------+------------------+-------+
| ID Name             EMail              Phone                      Company       Salary |
+---+----------------+------------------+---------------------+------------------+-------+
| 1  Leanne Graham    Sincere@april.biz  1-770-736-8031 x56442  Romaguera-Crona     3200 |
| 2  Ervin Howell     Shanna@melissa.tv  010-692-6593 x09125      Deckow-Crist       899 |
| 3  Clementine Bauch Nathan@yesenia.net 1-463-123-4447        Romaguera-Jacobson     99 |
| 4  Patricia Lebsack                                                                    |
+---+----------------+------------------+---------------------+------------------+-------+
```

### No Inner And No Outer Lines

```java
/* [...] */
TreeTableToTextConverter toTextConverter = new TreeTableToTextConverter()
    .withPrintInnerLines(false)
    .withPrintOuterLines(false);
System.out.println(table.toText(toTextConverter));
```

Console:

```text
ID Name             EMail              Phone                      Company       Salary
--+----------------+------------------+---------------------+------------------+------
1  Leanne Graham    Sincere@april.biz  1-770-736-8031 x56442  Romaguera-Crona     3200
2  Ervin Howell     Shanna@melissa.tv  010-692-6593 x09125      Deckow-Crist       899
3  Clementine Bauch Nathan@yesenia.net 1-463-123-4447        Romaguera-Jacobson     99
4  Patricia Lebsack                                                                   
```

## Tree Mode

### Column Alignment

```java
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

System.out.println(tree);
// same as System.out.println(tree.toText());
// same as System.out.println(tree.toText(new TreeTableToTextConverter());
```

Console:

```text
+---------------------+------------+------------+
| File                |       Date |       Size |
+---------------------+------------+------------+
| C:                  |            |            |
| +-- Windows         |            |            |
| |  +-- explorer.exe | 20.11.2014 |      4.800 |
| |  +-- regedit.exe  | 17.09.2014 |        360 |
| +-- Windows.old     |            |            |
| |  +-- explorer.exe | 20.11.2014 |      4.800 |
| |  +-- regedit.exe  | 17.09.2014 |        360 |
| +-- hiberfil.sys    | 01.01.2015 | 13.460.758 |
| +-- pagefile.sys    | 01.01.2015 |  4.112.754 |
| +-- swapfile.sys    | 01.01.2015 |      4.152 |
| D:                  |            |            |
| +-- Documents       |            |            |
| |  +-- todo.docx    | 20.11.2014 |      4.800 |
| |  +-- charts.xlsx  | 17.09.2014 |        360 |
| +-- test.png        | 01.01.2015 | 13.460.758 |
| +-- sample.html     | 01.01.2015 |  4.112.754 |
| +-- todo.txt        | 01.01.2015 |      4.152 |
+---------------------+------------+------------+
```

### Extended ASCII Lines

```java
/* [...] */
TreeTableToTextConverter toTextConverter = new TreeTableToTextConverter()
    .withASCIIExtended();
System.out.println(tree.toText(toTextConverter));
```

Console:

```text
┌─────────────────────┬────────────┬────────────┐
│ File                │       Date │       Size │
├─────────────────────┼────────────┼────────────┤
│ C:                  │            │            │
│ ├── Windows         │            │            │
│ │  ├── explorer.exe │ 20.11.2014 │      4.800 │
│ │  └── regedit.exe  │ 17.09.2014 │        360 │
│ ├── Windows.old     │            │            │
│ │  ├── explorer.exe │ 20.11.2014 │      4.800 │
│ │  └── regedit.exe  │ 17.09.2014 │        360 │
│ ├── hiberfil.sys    │ 01.01.2015 │ 13.460.758 │
│ ├── pagefile.sys    │ 01.01.2015 │  4.112.754 │
│ └── swapfile.sys    │ 01.01.2015 │      4.152 │
│ D:                  │            │            │
│ ├── Documents       │            │            │
│ │  ├── todo.docx    │ 20.11.2014 │      4.800 │
│ │  └── charts.xlsx  │ 17.09.2014 │        360 │
│ ├── test.png        │ 01.01.2015 │ 13.460.758 │
│ ├── sample.html     │ 01.01.2015 │  4.112.754 │
│ └── todo.txt        │ 01.01.2015 │      4.152 │
└─────────────────────┴────────────┴────────────┘
```
