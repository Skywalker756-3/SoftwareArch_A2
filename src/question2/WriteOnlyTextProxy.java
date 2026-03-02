class WriteOnlyTextProxy implements TextSubject {
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