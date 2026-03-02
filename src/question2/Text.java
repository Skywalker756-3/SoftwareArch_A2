class Text implements TextSubject {
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