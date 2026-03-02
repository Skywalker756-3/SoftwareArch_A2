class ReadOnlyTextProxy implements TextSubject {
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