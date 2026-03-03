package question2;
//  interface Subject
interface TextSubject {
    void setContent(String newContent);
    String getContent();
}

// real Subject
public class Text implements TextSubject {
    private String content;

    @Override
    public void setContent(String newContent) {
        this.content = newContent;
    }

    @Override
    public String getContent() {
        return content;
    }
}

// read Only Proxy
public class ReadOnlyTextProxy implements TextSubject {
    private final TextSubject realText;

    public ReadOnlyTextProxy(TextSubject realText) {
        this.realText = realText;
    }

    @Override
    public void setContent(String newContent) {
        throw new UnsupportedOperationException("READ-ONLY: Writing is not allowed.");
    }

    @Override
    public String getContent() {
        return realText.getContent();
    }
}

// write Only Proxy
public class WriteOnlyTextProxy implements TextSubject {
    private final TextSubject realText;

    public WriteOnlyTextProxy(TextSubject realText) {
        this.realText = realText;
    }

    @Override
    public void setContent(String newContent) {
        realText.setContent(newContent);
    }

    @Override
    public String getContent() {
        throw new UnsupportedOperationException("WRITE-ONLY: Reading is not allowed.");
    }
}

// read / write Proxy
public class ReadWriteTextProxy implements TextSubject {
    private final TextSubject realText;

    public ReadWriteTextProxy(TextSubject realText) {
        this.realText = realText;
    }

    @Override
    public void setContent(String newContent) {
        realText.setContent(newContent);
    }

    @Override
    public String getContent() {
        return realText.getContent();
    }
}

public class Main {
    public static void main(String[] args) {

        TextSubject real = new Text();
        real.setContent("Initial content in real Text.");

        TextSubject readOnly = new ReadOnlyTextProxy(real);
        TextSubject writeOnly = new WriteOnlyTextProxy(real);
        TextSubject readWrite = new ReadWriteTextProxy(real);

        System.out.println("Real read: " + real.getContent());
        real.setContent("Real updated content.");
        System.out.println("Real read after write: " + real.getContent());

        System.out.println("ReadOnly read: " + readOnly.getContent());
        try {
            readOnly.setContent("Trying to write...");
        } catch (Exception e) {
            System.out.println("ReadOnly write blocked -> " + e.getMessage());
        }

        writeOnly.setContent("Written using WriteOnly proxy.");
        System.out.println("WriteOnly write succeeded.");
        try {
            System.out.println("WriteOnly read: " + writeOnly.getContent());
        } catch (Exception e) {
            System.out.println("WriteOnly read blocked -> " + e.getMessage());
        }

        System.out.println("ReadWrite read before: " + readWrite.getContent());
        readWrite.setContent("Updated using ReadWrite proxy.");
        System.out.println("ReadWrite read after: " + readWrite.getContent());

        System.out.println("Real now contains: " + real.getContent());
    }
}