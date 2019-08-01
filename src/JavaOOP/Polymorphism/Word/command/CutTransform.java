package JavaOOP.Polymorphism.Word.command;

import JavaOOP.Polymorphism.Word.contracts.TextTransform;

public class CutTransform implements TextTransform {
    private StringBuilder cuttedText;

    @Override
    public void invokeOn(StringBuilder text, int startIndex, int endIndex) {
        cuttedText = new StringBuilder(text.subSequence(startIndex, endIndex));
        text.delete(startIndex, endIndex);
    }

    public StringBuilder getCuttedText() {
        return this.cuttedText;
    }
}
