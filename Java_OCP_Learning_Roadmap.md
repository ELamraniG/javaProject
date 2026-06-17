# Java OCP SE 17 — Complete Project-Based Learning Roadmap

**Book:** OCP Oracle Certified Professional Java SE 17 Developer Study Guide (Selikoff & Boyarsky)
**Designed for:** Exam 1Z0-829 | No concurrency/multithreading included
**Mentor approach:** Real junior developer work, not academic exercises

---

## The Project: **SmartInventory — A Personal Finance & Product Tracker**

### What It Is

A command-line application that lets a user manage a personal inventory of products (e.g., pantry items, gadgets, books, tools), track their prices, monitor expiry dates, import/export data from files, and generate summary reports. It connects to a local SQLite database for persistence.

This is exactly the kind of internal tooling a junior developer might build or maintain at a real company — a CLI data management tool with file I/O, database access, domain modeling, and reporting.

### Why This Project Is Perfect for OCP

- It starts simple (plain classes, variables, printing) and grows naturally into a full-featured app.
- Every Java concept introduced *solves a real problem* in the app — nothing is invented just to practice syntax.
- It mirrors real junior work: domain modeling, data parsing, file import/export, error handling, reports, DB persistence.
- It avoids magic frameworks. You use only core Java SE and JDBC.
- The feature set maps directly to almost every OCP chapter.

---

## Final Result (What You Will Build)

By the end of the roadmap, SmartInventory will:

- Store products with categories, quantities, prices, and expiry dates
- Validate all input with proper checked and unchecked exceptions
- Read/write data from `.csv` and `.txt` files using Java I/O and NIO.2
- Serialize and deserialize product snapshots
- Query and persist data using JDBC with a SQLite database
- Filter, sort, and report using the Streams API
- Use lambdas and functional interfaces throughout
- Define product types using enums, sealed classes, and records
- Support multiple locales for price formatting and date display
- Be organized into a proper Java module

---

## Code Architecture Guidance — Introduction Order

This is the single most important part of the roadmap. Features introduced too early create confusion and bad habits.

| Concept | Introduce In Phase | Why Then |
|---|---|---|
| Variables, primitives, operators | Phase 1 | Foundation. Needed immediately. |
| Control flow, loops, switch | Phase 1 | Decisions and iteration from day one. |
| Methods, access modifiers | Phase 2 | Code gets longer; methods organize it. |
| String, StringBuilder, arrays | Phase 2 | Real data manipulation needs. |
| Classes, constructors, `this` | Phase 3 | You have data worth modeling as objects. |
| Inheritance, `super`, overriding | Phase 3 | You have multiple product types now. |
| Abstract classes | Phase 3 | After you feel the pain of duplicated logic. |
| Interfaces | Phase 3 | After abstract classes; different contract need. |
| Records (basics) | Phase 3 | Immutable data carriers alongside classes. |
| Sealed classes (basics) | Phase 3 | Restricting type hierarchies after learning inheritance. |
| Enums (basics) | Phase 3 | Type-safe constants alongside classes. |
| Exceptions (checked + unchecked) | Phase 4 | Invalid data and missing products need structured error handling. |
| Enums (advanced: fields, methods) | Phase 4 | Constants need to carry behavior. |
| Collections (List, Map, Set) | Phase 5 | Arrays are not enough anymore. |
| Generics | Phase 5 | You write the same code for different types. |
| Lambdas + functional interfaces | Phase 6 | Collections need filtering/sorting. |
| Records (deepened) + sealed (deepened) | Phase 6 | Pattern matching and functional use. |
| Streams API | Phase 7 | After lambdas feel natural. |
| Optional | Phase 7 | You keep returning null and it causes bugs. |
| File I/O (java.io) | Phase 8 | You need to save and load data. |
| NIO.2 (java.nio.file) | Phase 8 | You need to walk directories and watch files. |
| Serialization | Phase 8 | You want binary snapshots. |
| Localization & formatting | Phase 9 | Reports need currency and date formatting. |
| JDBC | Phase 10 | File storage is not enough; you need queries. |
| Modules (module-info.java) | Phase 11 | App is big enough to organize into modules. |

**Never introduce early:**
- Streams before lambdas feel comfortable
- Generics before you feel the pain of casting
- JDBC before file I/O is solid
- Advanced records/sealed patterns before plain classes are mastered
- NIO.2 before java.io
- Modules before the app is nearly complete

---

## Phase 1 — The Foundation: Running Java and Working with Data

**Covers:** Chapter 1 (Building Blocks), Chapter 2 (Operators), Chapter 3 (Making Decisions)

### Features to Implement

- A `Main` class with a `main` method that prints a welcome banner
- Hard-coded product data printed to the console:
  - Product name (String), quantity (int), price (double), in-stock (boolean)
- Simple arithmetic: calculate total value (quantity × price)
- Use `if/else` to print "Low stock" warning when quantity < 5
- Use a `for` loop with a counter to repeat a calculation (e.g., apply 5 different discount percentages to a price)
- Use `switch` to map a numeric category code to a display name

### Exact Java Concepts to Practice

- Primitive types: `int`, `double`, `boolean`, `char`
- Reference types: `String`, the difference from primitives
- Variable declaration, initialization, scope, and `var`
- Arithmetic, comparison, logical, and ternary operators
- Operator precedence and casting (e.g., `(int)` a double)
- `if/else if/else`, `switch` expressions (Java 14+ arrow syntax)
- `for`, `while`, `do/while`, `break`, `continue`
- `System.out.println` and string concatenation vs `String.format`

### What to Avoid

- No classes yet beyond `Main`
- No methods other than `main`
- No arrays yet
- No OOP at all

### What You Learn

How Java programs start and execute, how data lives in memory, how the JVM handles primitives vs references, and how control flow works. This is the "scripting in Java" phase.

### Folder Structure

```
smartinventory/
└── src/
    └── Main.java
```

### Common Beginner Mistakes

- Confusing `=` (assignment) with `==` (comparison)
- Integer division surprises: `5 / 2 == 2`, not `2.5`
- Forgetting that `String` comparison requires `.equals()`, not `==`
- Declaring variables outside their needed scope
- Using `double` for money (use `int` cents or `BigDecimal` later)

---

## Phase 2 — Methods, Classes, and Core APIs

**Covers:** Chapter 4 (Core APIs), Chapter 5 (Methods)

### Features to Implement

- Extract logic into named `static` methods: `printProduct()`, `calculateValue()`, `isLowStock()`
- Work with `String` methods: `.trim()`, `.toUpperCase()`, `.contains()`, `.split()`, `.substring()`
- Use `StringBuilder` to build a formatted product report line by line
- Store multiple products using a simple `String[]` array; iterate and print
- Add a date: use `LocalDate` to represent expiry dates; calculate days until expiry
- Implement a simple search: find a product by name using a loop

### Exact Java Concepts to Practice

- Method declaration, parameters, return types, `void`
- Method overloading (same name, different parameters)
- `static` vs instance context (all methods are static still — that is intentional)
- `String` immutability and key methods
- `StringBuilder` for mutable string building
- Arrays: declaration, initialization, indexing, `length`
- Multi-dimensional arrays (optional: a 2D price matrix)
- `LocalDate`, `LocalDateTime`, `Period`, `DateTimeFormatter`
- `Math` class methods: `Math.round()`, `Math.abs()`
- Wrapper classes: `Integer.parseInt()`, `Double.parseDouble()`, autoboxing basics

### What to Avoid

- No classes to represent products yet — this comes in Phase 3
- No inheritance
- No collections (List, Map) yet

### What You Learn

How to organize code into reusable methods, how Java's String pool and immutability work, how to manipulate dates with the modern API, and how arrays are the foundation of collections.

### Folder Structure

```
smartinventory/
└── src/
    ├── Main.java
    └── ProductUtils.java      ← static utility methods
```

### Common Beginner Mistakes

- Modifying a String thinking it changed the original
- Returning from a void method accidentally
- Off-by-one errors in array loops
- Using `new String()` unnecessarily
- Forgetting that `LocalDate` is immutable — `.plusDays()` returns a new object

---

## Phase 3 — Object-Oriented Design: Classes, Inheritance, Interfaces

**Covers:** Chapter 6 (Class Design), Chapter 7 (Beyond Classes)

### Features to Implement

- Create a `Product` class with fields, constructor, getters/setters, and `toString()`
- Create subclasses: `PerishableProduct` (has expiry date) and `ElectronicProduct` (has warranty)
- Create an `abstract` base class `InventoryItem` that `Product` extends
- Define a `Printable` interface with a `printSummary()` method; implement it in `Product`
- Define a `Discountable` interface with `applyDiscount(double rate)`; implement in `PerishableProduct`
- Introduce `sealed` classes: a sealed `ShippingOption` hierarchy with `StandardShipping`, `ExpressShipping`, `PickupOnly` as permitted subclasses
- Introduce `record` for a `PriceSnapshot(String productName, double price, LocalDate date)`
- Introduce a basic `enum Category { FOOD, ELECTRONICS, TOOLS }` — simple constants only for now
- Demonstrate polymorphism: hold an `InventoryItem[]` array and call `printSummary()` on each element

### Exact Java Concepts to Practice

- Class design: fields, constructors, `this`, `this()` constructor chaining
- Access modifiers: `public`, `protected`, `private`, package-private
- Encapsulation: private fields with public getters/setters
- `static` members and `static` initializers
- Inheritance: `extends`, `super`, method overriding, `@Override`
- `final` classes, methods, and variables
- Abstract classes: when to use vs interfaces
- Interfaces: default methods, static methods, multiple implementation
- `instanceof` and pattern matching (`instanceof Product p`)
- `sealed` classes and `permits`
- `record` types: auto-generated constructor, getters, `equals`, `hashCode`, `toString`
- Enums: basic declaration with constants, `values()`, `valueOf()` — advanced features in Phase 4
- Inner classes: static nested class for `Product.Builder` (Builder pattern preview)
- Polymorphism and reference casting

### What to Avoid

- No Collections (List, Map) as actual data structures yet — use arrays for all storage
- No lambdas or streams
- No exceptions handling yet (just `throws` declarations for now)
- Keep records simple — no compact constructors with validation yet (Phase 6)
- Keep sealed classes simple — no pattern matching in switch yet (Phase 6)

### What You Learn

This is the most important phase. You learn to model a real domain with OOP, understand when to use abstract classes vs interfaces, practice polymorphism, and see how Java 17's newer type features (records, sealed classes) fit into the hierarchy.

### Folder Structure

```
smartinventory/
└── src/
    ├── Main.java
    ├── model/
    │   ├── InventoryItem.java       ← abstract class
    │   ├── Product.java             ← extends InventoryItem
    │   ├── PerishableProduct.java   ← extends Product
    │   ├── ElectronicProduct.java   ← extends Product
    │   ├── PriceSnapshot.java       ← record
    │   ├── Category.java            ← basic enum
    │   ├── ShippingOption.java      ← sealed class hierarchy
    │   ├── Printable.java           ← interface (lives with the types it serves)
    │   └── Discountable.java        ← interface
    └── util/
        └── ProductUtils.java
```

### Common Beginner Mistakes

- Making everything public — practice proper encapsulation
- Forgetting to call `super()` when parent has no default constructor
- Overloading when you meant to override (use `@Override` always)
- Confusing abstract class (shared state + partial implementation) with interface (contract only)
- Records with mutable fields — records are meant to be immutable
- Trying to put too much logic in constructors

---

## Phase 4 — Defensive Programming: Exceptions and Enums

**Covers:** Chapter 11 (Exceptions and Localization — first half), deeper Chapter 7 enums

### Features to Implement

- Create a custom checked exception: `ProductNotFoundException`
- Create a custom unchecked exception: `InvalidQuantityException`
- Add a method `findProductByName(String name)` that throws `ProductNotFoundException`
- Add input validation to setters: `setQuantity(int q)` throws `InvalidQuantityException` if `q < 0`
- Implement a `try/catch/finally` block for safe product lookup
- Use multi-catch: `catch (ProductNotFoundException | InvalidQuantityException e)`
- Use try-with-resources (preview — a file reader stub for now)
- Expand the basic `Category` enum from Phase 3: add fields (`displayName`, `taxRate`), a constructor, a method `getTaxRate()`, and an abstract method overridden per constant
- Use `enum` in a `switch` expression

### Exact Java Concepts to Practice

- Checked vs unchecked exceptions — when to use each
- `Exception` vs `RuntimeException` hierarchy
- Creating custom exception classes with message constructors
- `try`, `catch`, `finally`, `throw`, `throws`
- Multi-catch blocks
- Try-with-resources (`AutoCloseable`)
- Exception chaining: `new MyException("msg", cause)`
- Suppressed exceptions
- Enum advanced features: abstract methods, fields, constructors
- `Enum.values()`, `Enum.valueOf()`, `Enum.ordinal()`, `Enum.name()`

### What to Avoid

- No file I/O yet (try-with-resources is introduced as a concept only)
- No streams or lambdas

### What You Learn

Defensive programming habits that junior developers often skip. You understand the exception hierarchy, when a caller must handle an exception vs when it is optional, and how to design meaningful error messages. Enums teach you to replace "magic strings" with type-safe constants that carry behavior.

### Folder Structure

```
smartinventory/
└── src/
    ├── model/            ← (as before)
    ├── exception/
    │   ├── ProductNotFoundException.java
    │   └── InvalidQuantityException.java
    └── util/
        └── ProductUtils.java
```

### Common Beginner Mistakes

- Catching `Exception` everywhere instead of specific types
- Swallowing exceptions silently in an empty `catch` block
- Throwing checked exceptions from constructors carelessly
- Using exceptions for normal control flow (e.g., catching `NumberFormatException` instead of validating first)
- Forgetting `finally` still runs even after a `return`

---

## Phase 5 — Managing Data: Collections and Generics

**Covers:** Chapter 9 (Collections and Generics)

### Features to Implement

- Replace arrays with an `ArrayList<Product>` as the inventory store
- Use a `HashMap<String, Product>` for fast product lookup by name
- Use a `HashSet<String>` to track unique product tags/labels
- Use a `TreeMap<LocalDate, List<Product>>` to group products by expiry date
- Write a generic utility method: `<T extends InventoryItem> void printAll(List<T> items)`
- Write a generic `Pair<A, B>` class used for price comparison results
- Use `Collections.sort()` with a `Comparator`
- Use wildcards: `List<? extends InventoryItem>` in a print method

### Exact Java Concepts to Practice

- `List` (`ArrayList`, `LinkedList`), `Set` (`HashSet`, `TreeSet`, `LinkedHashSet`), `Map` (`HashMap`, `TreeMap`, `LinkedHashMap`)
- Common Collection methods: `add`, `remove`, `contains`, `size`, `isEmpty`, `putIfAbsent`, `getOrDefault`
- Iterating: enhanced `for`, `Iterator`, `Map.entrySet()`
- `Comparator` and `Comparable`: natural ordering vs custom ordering
- Generics: type parameters `<T>`, bounded type parameters `<T extends X>`, wildcards `<?>`, `<? extends T>`, `<? super T>`
- Type erasure (understand why `List<String>` and `List<Integer>` are the same at runtime)
- `Collections` utility class: `sort`, `unmodifiableList`, `singletonList`, `emptyList`
- Autoboxing and unboxing with collections

### What to Avoid

- No streams yet — use explicit loops and Comparators
- No lambdas yet (pass Comparator as an anonymous class to feel the pain first)

### What You Learn

Collections are the workhorse of real Java development. You understand the difference between List, Set, and Map semantics. You feel the pain of anonymous Comparator classes — which makes lambdas feel like a natural relief in Phase 6. Generics teach you to write reusable, type-safe code.

### Folder Structure

```
smartinventory/
└── src/
    ├── model/
    ├── exception/
    ├── repository/
    │   └── InventoryRepository.java    ← manages the collections
    └── util/
        ├── ProductUtils.java
        └── GenericUtils.java
```

### Common Beginner Mistakes

- Using `==` to compare strings inside collections instead of `.equals()`
- Modifying a collection while iterating it (use `Iterator.remove()` or collect first)
- Confusing `HashMap` ordering (none) with `TreeMap` (sorted) and `LinkedHashMap` (insertion order)
- Forgetting that `HashSet` requires proper `equals()` and `hashCode()` on stored objects
- Over-using generics wildcards before understanding the simpler form

---

## Phase 6 — Modern Java: Lambdas, Functional Interfaces, and Advanced Type Features

**Covers:** Chapter 8 (Lambdas and Functional Interfaces), Chapter 7 deepened

### Features to Implement

- Replace anonymous `Comparator` classes with lambda expressions 
- Add a method `filterProducts(List<Product> products, Predicate<Product> filter)` and call it with a lambda
- Add a `applyToAll(List<Product> items, Consumer<Product>)` method for batch updates
- Add a `transformNames(List<Product> items, Function<Product, String>)` method
- Use `Supplier<Product>` as a product factory
- Use method references: `Product::getName`, `System.out::println`, `Product::new`
- Deepen `PriceSnapshot` record: add a compact constructor with validation (price must be > 0), custom methods, and use it as a functional data carrier
- Deepen sealed types: add a `sealed interface Notification permits LowStockNotification, ExpiryNotification` and use `switch` with pattern matching to dispatch behavior based on type

### Exact Java Concepts to Practice

- Lambda syntax: `() -> {}`, `x -> x * 2`, `(x, y) -> x + y`
- Functional interfaces: `Predicate<T>`, `Consumer<T>`, `Supplier<T>`, `Function<T,R>`, `BiFunction<T,U,R>`, `UnaryOperator<T>`
- Method references: static (`ClassName::method`), instance (`obj::method`), instance of arbitrary type (`ClassName::instanceMethod`), constructor (`ClassName::new`)
- Composing functions: `Predicate.and()`, `Predicate.or()`, `Predicate.negate()`, `Function.andThen()`, `Function.compose()`
- Custom functional interfaces with `@FunctionalInterface`
- Records deepened: compact constructors with validation logic, custom instance methods, implementing interfaces
- Sealed interfaces with `permits` and exhaustive `switch` with pattern matching (`case LowStockNotification n ->`)
- Pattern matching in `switch` expressions (guarded patterns with `when`)

### What to Avoid

- No streams yet — all processing still uses explicit loops + lambdas
- This distinction is intentional: lambdas are not streams

### What You Learn

Lambdas transform how you write Java. You understand that a lambda is an implementation of a functional interface — not magic syntax. Method references make code intention-revealing. Records with compact constructors and sealed types with pattern matching show you the modern, expressive side of Java's type system. This phase bridges the gap from OOP to functional-style Java.

### Common Beginner Mistakes

- Thinking lambdas are their own type (they implement a `@FunctionalInterface`)
- Using lambdas to capture and mutate external variables (must be effectively final)
- Confusing `Function<T,R>` (transforms) with `Consumer<T>` (side effects)
- Over-using method references when a lambda is clearer
- Creating a custom functional interface when a built-in one already fits

---

## Phase 7 — The Power of Streams and Optional

**Covers:** Chapter 10 (Streams), Optional from Chapter 10

### Features to Implement

- Replace all explicit filter loops with `stream().filter().collect(Collectors.toList())`
- Find the most expensive product: `stream().max(Comparator.comparingDouble(...))`
- Calculate total inventory value: `stream().mapToDouble(...).sum()`
- Group products by category: `stream().collect(Collectors.groupingBy(Product::getCategory))`
- Find products expiring within 7 days: chain `filter` + `sorted` + `limit`
- Generate a summary report using `stream().map(...).collect(Collectors.joining("\n"))`
- Replace `null` returns with `Optional<Product>`: `findProductByName()` returns `Optional<Product>`
- Use `Optional.orElse()`, `Optional.orElseThrow()`, `Optional.ifPresent()`, `Optional.map()`
- Use `flatMap` to flatten a stream of product tag lists into a single stream of tags

### Exact Java Concepts to Practice

- Stream pipeline: source → intermediate operations → terminal operations
- Intermediate: `filter`, `map`, `flatMap`, `sorted`, `distinct`, `peek`, `limit`, `skip`
- Terminal: `collect`, `forEach`, `count`, `min`, `max`, `findFirst`, `anyMatch`, `allMatch`, `noneMatch`, `reduce`
- Primitive streams: `IntStream`, `DoubleStream`, `LongStream`; `mapToInt`, `mapToDouble`, `sum`, `average`, `range`
- `Collectors`: `toList`, `toSet`, `toMap`, `joining`, `groupingBy`, `partitioningBy`, `counting`, `summarizingDouble`
- `Optional<T>`: creation, access, chaining, avoiding null
- Lazy evaluation: intermediate operations don't execute until terminal
- Stream reuse mistake: streams can only be consumed once
- Parallel streams (mention only — avoid using)

### What to Avoid

- No parallel streams (that is concurrency)
- Avoid `peek()` for production logic — it is for debugging only

### What You Learn

Streams are how modern Java processes data collections declaratively. You see that a stream pipeline reads like a specification of what you want, not how to do it. `Optional` finally gives you a disciplined way to handle the absence of a value without null pointer exceptions.

### Common Beginner Mistakes

- Storing intermediate results in variables (streams are not collections)
- Calling a terminal operation twice on the same stream (throws `IllegalStateException`)
- Using `peek()` as a substitute for `map` or `forEach`
- Confusing `map` (1-to-1 transform) with `flatMap` (1-to-many, flatten)
- Returning `null` from inside a lambda — use `Optional` instead

---

## Phase 8 — File I/O, Serialization, and NIO.2

**Covers:** Chapter 14 (I/O)

### Features to Implement

- Write a `CsvExporter` that writes all products to a `.csv` file using `BufferedWriter`
- Write a `CsvImporter` that reads `.csv` files with `BufferedReader` and parses each line into a `Product`
- Serialize the entire inventory to a binary snapshot file using `ObjectOutputStream`
- Deserialize the snapshot back using `ObjectInputStream`
- Use `Path` and `Files` (NIO.2) to:
  - Check if a file exists before writing
  - List all `.csv` files in a directory
  - Copy a backup of the inventory file
  - Walk a directory tree to find all report files
- Implement a `try-with-resources` block for every I/O operation
- Use `Files.readAllLines()` and `Files.writeString()` for simple cases

### Exact Java Concepts to Practice

- `java.io` stream hierarchy: `InputStream`, `OutputStream`, `Reader`, `Writer`
- High-level streams: `FileReader`, `FileWriter`, `BufferedReader`, `BufferedWriter`, `PrintWriter`
- Object streams: `ObjectInputStream`, `ObjectOutputStream`, `Serializable`, `serialVersionUID`
- `transient` keyword for fields to exclude from serialization
- `java.nio.file`: `Path`, `Paths.get()`, `Files`, `Path.of()`
- `Files` methods: `exists`, `createFile`, `createDirectory`, `delete`, `copy`, `move`, `readAllLines`, `writeString`, `newBufferedReader`, `newBufferedWriter`
- `Files.walk()` and `Files.list()` with streams
- `try-with-resources` with multiple `AutoCloseable` resources
- `IOException` and its subclasses
- File encoding: always specify `StandardCharsets.UTF_8`

### What to Avoid

- Do not use `File` (legacy) when `Path` (NIO.2) works — always prefer NIO.2 for new code
- Do not catch and ignore `IOException`

### What You Learn

This phase teaches you how real applications persist and load data. You understand the layered I/O stream system, when to use character vs byte streams, and why NIO.2 is the modern replacement for the legacy `File` API. Serialization shows you binary persistence and its trade-offs.

### Folder Structure

```
smartinventory/
└── src/
    ├── model/
    ├── exception/
    ├── repository/
    ├── io/
    │   ├── CsvExporter.java
    │   ├── CsvImporter.java
    │   └── SnapshotManager.java     ← serialization
    └── util/
```

### Common Beginner Mistakes

- Not closing streams (always use try-with-resources)
- Mixing byte streams and character streams incorrectly
- Not specifying character encoding (platform default is unreliable)
- Forgetting `serialVersionUID` in `Serializable` classes
- Making a field `transient` and forgetting it will be null after deserialization
- Using `File.separator` — use `Path` instead, which is OS-agnostic

---

## Phase 9 — Localization, Formatting, and Internationalization

**Covers:** Chapter 11 (Exceptions and Localization — second half)

### Features to Implement

- Format prices using `NumberFormat.getCurrencyInstance(Locale)` — support USD and EUR
- Format dates using `DateTimeFormatter.ofLocalizedDate(FormatStyle.MEDIUM)` per locale
- Use `ZonedDateTime` to display product creation timestamps adjusted to different time zones
- Add a `messages.properties` and `messages_es.properties` resource bundle for app messages
- Load locale from a user preference setting; fall back to `Locale.getDefault()`
- Add a report header that changes language based on locale: "Inventory Report" / "Reporte de Inventario"
- Format numbers with `%,.2f` in `String.format()`

### Exact Java Concepts to Practice

- `Locale`: `Locale.US`, `Locale.FRANCE`, `new Locale("es", "MX")`, `Locale.getDefault()`
- `ZonedDateTime`, `ZoneId`, converting between `LocalDateTime` and `ZonedDateTime`
- `NumberFormat`: `getCurrencyInstance`, `getNumberInstance`, `getPercentInstance`, `parse()`
- `DateTimeFormatter`: `ofPattern`, `ofLocalizedDate`, `ofLocalizedDateTime`, `FormatStyle`
- `ResourceBundle`: `ResourceBundle.getBundle()`, `.getString()`, property files naming convention
- `String.format()` and `printf` format specifiers: `%s`, `%d`, `%f`, `%,.2f`, `%tD`
- `MessageFormat` for parameterized messages

### What You Learn

Real applications are international. You understand how Java separates number/date formatting from locale, how resource bundles let you externalize strings without code changes, and how to produce human-readable output that adapts to the user's region.

### Folder Structure

```
smartinventory/
└── src/
    ├── model/
    ├── exception/
    ├── repository/
    ├── io/
    ├── report/
    │   └── ReportGenerator.java      ← locale-aware reporting
    ├── resources/
    │   ├── messages.properties
    │   └── messages_es.properties
    └── util/
```

### Common Beginner Mistakes

- Hard-coding date formats as strings like `"MM/dd/yyyy"` instead of using `FormatStyle`
- Forgetting that `NumberFormat.parse()` is locale-sensitive (a comma is a decimal in some locales)
- Missing resource bundle files (throws `MissingResourceException`)
- Not handling `Locale.setDefault()` side effects in library code

---

## Phase 10 — Database Persistence with JDBC

**Covers:** Chapter 15 (JDBC)

### Features to Implement

- Create a SQLite database file `inventory.db` with a `products` table
- Write a `DatabaseManager` class that:
  - Opens/closes `Connection` with a data source URL
  - Creates the schema if it does not exist
- Write a `ProductDao` class (Data Access Object) with:
  - `insert(Product p)` using `PreparedStatement`
  - `findAll()` returning `List<Product>` from a `ResultSet`
  - `findByCategory(Category c)` with a `WHERE` clause parameter
  - `update(Product p)` for quantity changes
  - `delete(String name)` by product name
- Implement a transaction: deduct from one product and add to another atomically
- Handle a stored procedure call (optional: a SQLite view acting as a report query)

### Exact Java Concepts to Practice

- JDBC interfaces: `Connection`, `Statement`, `PreparedStatement`, `CallableStatement`, `ResultSet`
- `DriverManager.getConnection(url)` and JDBC URLs
- `PreparedStatement` for parameterized queries (always use this, not `Statement`, to avoid SQL injection)
- `ResultSet` traversal: `next()`, `getString()`, `getInt()`, `getDouble()`, `getDate()`
- Transactions: `connection.setAutoCommit(false)`, `commit()`, `rollback()`
- `try-with-resources` for `Connection`, `PreparedStatement`, `ResultSet`
- `SQLException` and checking `getSQLState()`
- The DAO design pattern

### What to Avoid

- Do not use a JPA/Hibernate framework — you need to understand raw JDBC first
- Do not put SQL strings in `Main` — always use a DAO class

### What You Learn

Database access is universal in Java back-end work. You understand how JDBC bridges Java objects and relational data, why `PreparedStatement` is mandatory (not optional), how transactions guarantee consistency, and how the DAO pattern separates data access from business logic.

### Folder Structure

```
smartinventory/
└── src/
    ├── model/
    ├── exception/
    ├── dao/
    │   ├── ProductDao.java          ← replaces in-memory repository
    │   └── DatabaseManager.java
    ├── io/
    └── util/
```

### Common Beginner Mistakes

- Using `Statement` with string concatenation (SQL injection vulnerability)
- Not closing `Connection` (leaks database connections)
- Not calling `connection.setAutoCommit(false)` before a transaction
- Forgetting `rollback()` in a `catch` block
- Catching `SQLException` silently without logging or rethrowing
- Confusing `ResultSet.getDate()` (java.sql.Date) with `LocalDate`; convert with `.toLocalDate()`

---

## Phase 11 — Modules

**Covers:** Chapter 12 (Modules)

### Features to Implement

- Convert the project into a named module: `module smartinventory`
- Write `module-info.java` with `requires` and `exports` directives
- Split into two modules: `smartinventory.model` and `smartinventory.app`
- Export only the public API packages; keep internals private
- Use `requires java.sql` for JDBC
- Demonstrate a service: define a `ReportService` interface in the model module; provide an implementation in the app module using `provides`/`uses`

### Exact Java Concepts to Practice

- `module-info.java`: `module`, `requires`, `exports`, `opens`, `uses`, `provides ... with`
- Compilation and running with `--module-path` and `-m`
- `requires transitive`
- Unnamed module vs named module
- Strong encapsulation: internal packages are inaccessible without `exports`
- Service loader pattern: `ServiceLoader<ReportService>`

### What You Learn

Modules teach you how Java SE 9+ enforces encapsulation at the package level. This is increasingly used in enterprise Java projects and is fully tested on the OCP exam.

### Common Beginner Mistakes

- Forgetting to `requires` a module that is implicitly used
- `exports` vs `opens` confusion (exports for compile-time; opens for reflection)
- Trying to use the service loader without both `provides` and `uses`

---

## Learning Progression Summary

```
Phase 1   → Variables, operators, control flow          (Ch. 1, 2, 3)
Phase 2   → Methods, String, arrays, dates              (Ch. 4, 5)
Phase 3   → Classes, inheritance, interfaces,           (Ch. 6, 7)
             records, sealed classes (basics)
Phase 4   → Exceptions, enums (advanced)                (Ch. 11a, 7)
Phase 5   → Collections, generics                       (Ch. 9)
Phase 6   → Lambdas, functional interfaces,             (Ch. 8, 7 deepened)
             records + sealed (advanced)
Phase 7   → Streams, Optional                           (Ch. 10)
Phase 8   → File I/O, NIO.2, serialization              (Ch. 14)
Phase 9   → Localization, formatting                    (Ch. 11b)
Phase 10  → JDBC                                        (Ch. 15)
Phase 11  → Modules                                     (Ch. 12)
```

**Not covered by design:** Chapter 13 (Concurrency) — study separately after completing this roadmap.

---

## Design Patterns Introduced Progressively

| Pattern | Phase | How It Appears |
|---|---|---|
| Utility class (static methods) | 2 | `ProductUtils` with only static methods |
| Builder | 3 | `Product.Builder` inner class |
| Template Method | 3 | Abstract `InventoryItem.printSummary()` |
| Strategy | 6 | `Comparator` as a lambda |
| Factory Method | 6 | `Supplier<Product>` as a product factory |
| Callback | 6 | `Consumer<Product>` for batch operations |
| DAO | 10 | `ProductDao` isolates all SQL |
| Service Locator | 11 | `ServiceLoader<ReportService>` |

---

## Final Project Checklist — OCP Skills Mastered

After completing all 11 phases, you will have practiced:

- Java program structure, JVM basics, garbage collection concepts
- All primitive and reference types, variable scoping, `var`
- All standard operators (arithmetic, comparison, logical, ternary, assignment); bitwise and shift operators are exam topics — study them from the book alongside Phase 1
- All control flow: if/else, switch expressions, all loop forms, pattern matching
- String manipulation, StringBuilder, all String methods
- Arrays, multi-dimensional arrays
- Date/time API: LocalDate, LocalDateTime, ZonedDateTime, Period, Duration, DateTimeFormatter
- Full OOP: encapsulation, inheritance, polymorphism, abstraction
- Abstract classes and interfaces including default/static/private interface methods
- Records and compact constructors
- Sealed classes and interfaces
- Enums with fields, methods, and abstract methods
- All nested class types
- Checked and unchecked exceptions, custom exception hierarchy, try-with-resources
- All major collection types and their performance trade-offs
- Generics and wildcards
- Lambdas and all built-in functional interfaces
- Method references (all four kinds)
- Stream API end-to-end with all terminal and intermediate operations
- Optional properly used
- java.io stream hierarchy
- NIO.2 Path and Files API
- Object serialization and deserialization
- Localization with Locale, NumberFormat, ResourceBundle, DateTimeFormatter
- JDBC: Connection, PreparedStatement, ResultSet, transactions, DAO pattern
- Java module system with services

This is a comprehensive, exam-relevant, and professionally structured skillset. Good luck.
