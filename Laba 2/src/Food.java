class Food {
    private Taste taste;

    Food() {
        this.taste = Taste.TASTELESS;
    }
    Food(Taste taste){
        this.taste = taste;
    }
    Taste getTaste() {
        return taste;
    }
}