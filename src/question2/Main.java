public class Main {

    public static void main(String[] args) {

        // Real Subject
        Text realText = new Text();
        realText.setContent("Initial content in real Text.");

        System.out.println("Real read: " + realText.getContent());

        realText.setContent("Real updated content.");
        System.out.println("Real read after write: " + realText.getContent());


        // Read-Only Proxy
        TextSubject readOnly = new ReadOnlyTextProxy(realText);

        System.out.println("ReadOnly read: " + readOnly.getContent());

        try {
            readOnly.setContent("Trying to write...");
        } catch (Exception e) {
            System.out.println("ReadOnly write blocked -> " + e.getMessage());
        }


        // Write-Only Proxy
        TextSubject writeOnly = new WriteOnlyTextProxy(realText);

        writeOnly.setContent("Written using WriteOnly proxy.");
        System.out.println("WriteOnly write succeeded.");

        try {
            System.out.println(writeOnly.getContent());
        } catch (Exception e) {
            System.out.println("WriteOnly read blocked -> " + e.getMessage());
        }


        // Read/Write Proxy
        TextSubject readWrite = new ReadWriteTextProxy(realText);

        System.out.println("ReadWrite read before: " + readWrite.getContent());

        readWrite.setContent("Updated using ReadWrite proxy.");

        System.out.println("ReadWrite read after: " + readWrite.getContent());


        // Final Check
        System.out.println("Real now contains: " + realText.getContent());
    }
}