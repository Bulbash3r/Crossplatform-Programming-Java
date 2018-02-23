

class GUI {
    public static void main (String[] args)
    {
        Display display = new Display();
        Shell shell = new Shell(Display);
        shell.open();
        shell.forceActive();
    }
}