# Java Practice Tasks

Four small Java programs.

| File | Task |
|------|------|
| `RectangleArea.java` | Area of a rectangle using method overloading (`int` -> `int`, `double` -> `double`) |
| `DaysBetweenDates.java` | Number of days between two dates |
| `DigitSum.java` | Recursive sum of digits of a natural number (e.g. `1342` -> `10`) |
| `DirectorySize.java` | Checks a directory, prints total size in MB / KB / bytes and the size of every subdirectory |

## How to run

Requires JDK 11 or newer.

```bash
javac *.java

java RectangleArea
java DaysBetweenDates
java DigitSum
java DirectorySize            # asks for a directory name
java DirectorySize /some/path # or pass it as an argument
```
