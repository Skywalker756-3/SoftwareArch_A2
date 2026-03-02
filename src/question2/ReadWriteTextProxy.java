class ReadWriteTextProxy implements TextSubject {
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