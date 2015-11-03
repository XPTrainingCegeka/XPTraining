package movierental;

public class Movie {

	public static final int CHILDRENS = 2;
	public static final int NEW_RELEASE = 1;
	public static final int REGULAR = 0;

	private String title;
	private MovieCalculation movieCalculation;
	private MovieType movieType;

	public Movie(String title, MovieType movieType) {
		this.title = title;
		this.movieType = movieType;
		this.movieCalculation = chooseMovieCalculation(movieType);
	}

	private MovieCalculation chooseMovieCalculation(MovieType movieType) {
		switch (movieType) {
		case CHILDRENS:
			return new ChildrenMovie();
		case NEW_RELEASE:
			return new NewRelease();
		case REGULAR:
			return new RegularMovie();
		default:
			return null;
		}
	}

	public String getTitle() {
		return title;
	}

	public void setMovieCalculation(MovieCalculation mc) {
		this.movieCalculation = mc;
	}

	public double calculateAmount(int daysRented) {
		return movieCalculation.calculateAmount(daysRented);

	}

	public MovieType getMovieType() {
		return movieType;
	}

	public void setMovieType(MovieType movieType) {
		this.movieType = movieType;
	}

}
