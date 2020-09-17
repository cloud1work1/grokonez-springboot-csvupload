# grokonez-springboot-csvupload

- ## pom.xml
  ```
  <dependency>
    <groupId>org.apache.commons</groupId>
    <artifactId>commons-csv</artifactId>
    <version>1.5</version>
  </dependency>
  ```
- ## util.java
  ```
  public static List<User> parseCSVFile(InputStream is) {
    List<User> users=null;
    BufferedReader br = new BufferedReader(new InputStreamReader(is);
    CSVParser parser = new CSVParser(br, CSVFormat.Default.withFirstRecordAsHeader().withIgnoreHeaderCase().withTrim());
    Iterable<CSVRecord> records = parser.getRecords();
    for(CSVRecord record: records) {
     User user = new User(
       Long.parseLong(record.get("id")),
       record.get("name"),
       record.get("address"),
       Integer.parseInt(record.get("age"))
     );
     users.add(user);
    }
    return users;
  }
  ```
- ## controller.java
  ```
  @RequestParam("file") MultipartFile file
  file.getInputStream();
  ```
