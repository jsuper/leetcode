import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.StringTokenizer;
import java.util.stream.Collectors;

public class TestMemory {

  public static void main(String[] args) throws IOException {
    System.out.println(getArrayListOfLineWidthDelimiter("Mem:    8389947392 3643547648 4746399744     544768   " +
      "30097408 1400008704", " "));
   /* String property = System.getProperty("os.name").toLowerCase();

    Path path = Paths.get("/etc");
    Path resolve = path.resolve("*-release");
    Optional<Path> first = Files.list(path).filter(p -> p.getFileName().toString().matches(".*-release")).findFirst();
    boolean isUbuntu = false;
    if (first.isPresent()) {
      System.out.println(first.get());
      byte[] bytes = Files.readAllBytes(first.get());
      String x = new String(bytes).toLowerCase();

      if (x.indexOf("ubuntu") >= 0) {
        System.out.println("Current is ubuntu");
        isUbuntu = true;
      } else if (x.indexOf("centos") >= 0) {
        System.out.println("Current is centos");
      } else {
        System.out.println("Other linux release");
      }
    }

    System.out.println(property);
    if (property.indexOf("linux") >= 0) {
      System.out.println("is linux");
      try {
        String cmd = "free -k";
        if (isUbuntu) {
          cmd += " -w";
        }
        Process exec = Runtime.getRuntime().exec(cmd);
        int available = exec.getInputStream().available();
        ByteArrayOutputStream bos = new ByteArrayOutputStream(available);
        byte[] temp = new byte[1024];
        int len = 0;
        while ((len = exec.getInputStream().read(temp)) != -1) {
          bos.write(temp, 0, len);
        }

        String output = bos.toString("UTF-8");

        String[] split = output.split("\n");
        if (split != null && split.length >= 2) {
          List<String> labelLine = getArrayListOfLineWidthDelimiter(split[0], " ");
          List<String> mem = getArrayListOfLineWidthDelimiter(split[1], " ")
            .stream().filter(e -> e.matches("\\d+")).collect(Collectors.toList());

          System.out.println("Title: " + labelLine);
          System.out.println("Memory: " + mem);

          if (labelLine.size() == mem.size()) {

            Map<String, Long> data = new HashMap<>();
            for (int i = 0; i < labelLine.size(); i++) {
              data.put(labelLine.get(i), Long.parseLong(mem.get(i)));
            }

            System.out.println(data);
          }
        }

      } catch (IOException e) {
        e.printStackTrace();
      }
    }*/
  }

  private static List<String> getArrayListOfLineWidthDelimiter(String line, String deli) {
    List<String> data = new ArrayList<>();
    StringTokenizer tokenizer = new StringTokenizer(line, deli);
    while (tokenizer.hasMoreTokens()) {
      data.add(tokenizer.nextToken());
    }
    return data;
  }
}
