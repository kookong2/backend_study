package day20.sub2;

public enum Transportation {	// abstract Transportation // enum 클래스는 추상클래스
	BUS("버스"){
		public void method() {}
	}, 	// 객체1			// public static final Transportation Bus = new Transportation ...
	SUBWAY("지하철"){
		public void method() {}// 객체2
	},
	TAXI("택시"){
		public void method() {}
	};	// 객체3

	private String name;
	
	Transportation(String name) {
		
		this.name = name;
	}
	
	public String getName() {
		
		return name;
	}

	
}
