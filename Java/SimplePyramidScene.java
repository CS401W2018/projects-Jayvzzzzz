import java.awt.Color;
import java.awt.Graphics;
import javax.swing.JFrame; // Import FontMetrics to measure text
import javax.swing.JPanel;

public class SimplePyramidScene extends JPanel {

    // Constructor
    public SimplePyramidScene() {
        // No custom initialization needed
    }

    // paintComponent: Called by the system to draw
    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g); // Clear the panel

        // Get panel dimensions
        var w = getWidth();
        var h = getHeight();

        // Draw Sky
        g.setColor(Color.CYAN);
        g.fillRect(0, 0, w, h);

        // Draw Sun
        g.setColor(Color.YELLOW);
        var sunX = 20;
        var sunY = 20;
        var sunWidth = 80;
        var sunHeight = 80;
        g.fillOval(sunX, sunY, sunWidth, sunHeight);

        // Draw Hills (Left hill made tallest)
        g.setColor(Color.GREEN);

        // Calculate ground position for reference
        var groundHeight = h / 4;
        var groundY = h - groundHeight; // Top edge of the ground

        // Properties for the new tallest hill (positioned on the left)
        var tallestHillX = -50;
        var tallestHillWidth = 280; // Increased width to make it taller
        var tallestHillHeight = 350; // Increased height to make it the tallest

        // Calculate Y for the tallest hill so its base is near the ground line
        var tallestHillY = groundY - tallestHillHeight + 50; // Adjust Y so the base is around groundY + 50


        // Properties for the center hill (remains the same size and position)
        var centerHillX = 150;
        var centerHillY = 100;
        var centerHillWidth = 250;
        var centerHillHeight = 300;

        // Properties for the hill on the right (remains the same size and position)
        var rightHillX = 350;
        var rightHillY = 150;
        var rightHillWidth = 200;
        var rightHillHeight = 250;

        // Draw the new tallest hill (on the left)
        g.fillOval(tallestHillX, tallestHillY, tallestHillWidth, tallestHillHeight);

        // Draw the center hill
        g.fillOval(centerHillX, centerHillY, centerHillWidth, centerHillHeight);

        // Draw the hill on the right
        g.fillOval(rightHillX, rightHillY, rightHillWidth, rightHillHeight);


        // Draw Ground
        // Changed ground color to a slightly darker green
        g.setColor(new Color(80, 180, 80)); // A darker green using RGB values
        g.fillRect(0, groundY, w, groundHeight);


        // --- Draw Sign ---
        var stepHeight = 30; // Get stepHeight for sign height

        var signBoardWidth = 100; // Keep the current width
        var signBoardHeight = 2 * stepHeight; // Keep the current height (2 steps tall)

        // Position the sign board
        var signBoardX = 400; // Position further to the right
        var signBoardY = (h / 2) - 50; // Position in the upper half of the panel

        var stickWidth = 15; // Keep stick width
        var stickX = signBoardX + (signBoardWidth - stickWidth) / 2;
        var stickY = signBoardY + signBoardHeight; // Stick starts at the bottom of the board

        // Calculate stickHeight so it touches the ground
        var stickEndY = groundY; // The stick should end exactly at the ground line
        var stickHeight = stickEndY - stickY; // Height needed to reach the ground from stickY


        // Brown color for the sign components
        var brownColor = new Color(139, 69, 19); // Saddle Brown

        // Draw the stick
        g.setColor(brownColor);
        // Only draw the stick if its height is positive
        if (stickHeight > 0) {
            g.fillRect(stickX, stickY, stickWidth, stickHeight);
        }


        // Draw the sign board
        g.setColor(brownColor);
        g.fillRect(signBoardX, signBoardY, signBoardWidth, signBoardHeight);

        // Draw the text on the sign board (two lines: "John's" and "Pyramid")
        g.setColor(Color.BLACK);
        var line1 = "John's";
        var line2 = "Pyramid";

        // Get font metrics to calculate text position for centering
        var fm = g.getFontMetrics();
        var textWidth1 = fm.stringWidth(line1);
        var textWidth2 = fm.stringWidth(line2);
        var lineHeight = fm.getHeight(); // Height of a single line including leading
        var lineGap = 5; // Vertical gap between the two lines

        // Calculate vertical position for the block of text
        var totalTextHeight = 2 * lineHeight + lineGap;
        var startY = signBoardY + (signBoardHeight - totalTextHeight) / 2; // Top Y coordinate for the block of text

        // Calculate baseline Y for each line
        var textBaselineY1 = startY + fm.getAscent(); // Baseline for the first line
        var textBaselineY2 = textBaselineY1 + lineHeight + lineGap; // Baseline for the second line

        // Calculate horizontal position for each line (centered)
        var textX1 = signBoardX + (signBoardWidth - textWidth1) / 2;
        var textX2 = signBoardX + (signBoardWidth - textWidth2) / 2;

        // Draw the text lines
        g.drawString(line1, textX1, textBaselineY1);
        g.drawString(line2, textX2, textBaselineY2);
        // --- End Draw Sign ---


        // Draw the Pyramid
        g.setColor(new Color(255, 165, 0)); // Orange

        // Recalculate pyramidBaseY as stepHeight is used before its definition above
        // Calculate the Y coordinate for the pyramid's conceptual base line
        // so the ground top is at the midpoint of the bottom step.
        var pyramidBaseY = groundY + stepHeight / 2;

        var baseWidth = 260;
        var stepDecrease = 30;

        // Draw each step, calculating Y based on pyramidBaseY
        var stepWidth1 = baseWidth;
        var stepX1 = (w - stepWidth1) / 2;
        var stepY1 = pyramidBaseY - stepHeight; // Top of the bottom step
        g.fillRect(stepX1, stepY1, stepWidth1, stepHeight);

        var stepWidth2 = stepWidth1 - stepDecrease;
        var stepX2 = (w - stepWidth2) / 2;
        var stepY2 = stepY1 - stepHeight;
        g.fillRect(stepX2, stepY2, stepWidth2, stepHeight);

        var stepWidth3 = stepWidth2 - stepDecrease;
        var stepX3 = (w - stepWidth3) / 2;
        var stepY3 = stepY2 - stepHeight;
        g.fillRect(stepX3, stepY3, stepWidth3, stepHeight);

        var stepWidth4 = stepWidth3 - stepDecrease;
        var stepX4 = (w - stepWidth4) / 2;
        var stepY4 = stepY3 - stepHeight;
        g.fillRect(stepX4, stepY4, stepWidth4, stepHeight);

        // Corrected: Removed the erroneous line and used the correct calculation for the 5th step width
        var stepWidth5 = stepWidth4 - stepDecrease;
        var stepX5 = (w - stepWidth5) / 2;
        var stepY5 = stepY4 - stepHeight;
        g.fillRect(stepX5, stepY5, stepWidth5, stepHeight);


        // Draw Pyramid Step Outlines (horizontal lines)
        g.setColor(Color.BLACK);
        var lineYOffset = stepHeight / 2; // Draw line in the middle of the step height
        var lineLengthFraction = 0.4f;

        // Lines are drawn relative to the step's top Y coordinate
        var lineX1Start = stepX1 + (int) (stepWidth1 * (1 - lineLengthFraction) / 2);
        var lineY1 = stepY1 + lineYOffset;
        var lineX1End = stepX1 + (int) (stepWidth1 * (1 + lineLengthFraction) / 2);
        g.drawLine(lineX1Start, lineY1, lineX1End, lineY1);

        var lineX2Start = stepX2 + (int) (stepWidth2 * (1 - lineLengthFraction) / 2);
        var lineY2 = stepY2 + lineYOffset;
        var lineX2End = stepX2 + (int) (stepWidth2 * (1 + lineLengthFraction) / 2);
        g.drawLine(lineX2Start, lineY2, lineX2End, lineY2);

        var lineX3Start = stepX3 + (int) (stepWidth3 * (1 - lineLengthFraction) / 2);
        var lineY3 = stepY3 + lineYOffset;
        var lineX3End = stepX3 + (int) (stepWidth3 * (1 + lineLengthFraction) / 2);
        g.drawLine(lineX3Start, lineY3, lineX3End, lineY3);

        var lineX4Start = stepX4 + (int) (stepWidth4 * (1 - lineLengthFraction) / 2);
        var lineY4 = stepY4 + lineYOffset;
        var lineX4End = stepX4 + (int) (stepWidth4 * (1 + lineLengthFraction) / 2);
        g.drawLine(lineX4Start, lineY4, lineX4End, lineY4);

        // Corrected: Use the correctly calculated stepWidth5
        var lineX5Start = stepX5 + (int) (stepWidth5 * (1 - lineLengthFraction) / 2);
        var lineY5 = stepY5 + lineYOffset;
        var lineX5End = stepX5 + (int) (stepWidth5 * (1 + lineLengthFraction) / 2);
        g.drawLine(lineX5Start, lineY5, lineX5End, lineY5);

        // Draw the Rectangle on top
        var rectWidth = 70;
        var rectHeight = 50;
        var rectX = (w - rectWidth) / 2;
        var rectY = stepY5 - rectHeight; // Position above the top step

        g.setColor(new Color(255, 165, 0)); // Orange
        g.fillRect(rectX, rectY, rectWidth, rectHeight);

        // Draw the Oval inside the Rectangle
        var circleDiameter = rectWidth - 10;
        var circleHeight = rectHeight - 10;
        var circleX = rectX + 5; // Center oval
        var circleY = rectY + 5; // Center oval

        g.setColor(Color.BLACK); // Black outline
        g.drawOval(circleX, circleY, circleDiameter, circleHeight);
    }

    // main method: Entry point
    public static void main(String[] args) {
        var window = new JFrame("Simple Pyramid Scene");
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        window.setSize(500, 450); // Keep the window size
        window.setContentPane(new SimplePyramidScene());
        window.setVisible(true);
    }
}