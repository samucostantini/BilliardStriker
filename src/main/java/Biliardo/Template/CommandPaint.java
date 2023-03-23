package Biliardo.Template;

import java.awt.*;

public abstract class CommandPaint {
    public void execute(Graphics2D g2d) {
        // passo 1

        step1(g2d);

        // passo 2
        step2(g2d);

        // passo 3
        step3(g2d);
    }

    protected abstract void step1(Graphics2D g2d);
    protected abstract void step2(Graphics2D g2d);
    protected abstract void step3(Graphics2D g2d);
}

