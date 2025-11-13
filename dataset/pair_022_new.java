public class Settings {
    private boolean enabled = true;

    public void toggle() {
        enabled = !enabled;
        System.out.println("Toggled"); // new line added
    }
}
