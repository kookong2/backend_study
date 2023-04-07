package week06;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class Bag {
	public static void main(String[] args) {
		
		int capacity = 40;
		
		ArrayList<Product> s = new ArrayList<Product>();
		s.add(new Product("주석",50, 50000));
		s.add(new Product("백금",10, 600000));
		s.add(new Product("은",25, 100000));
		s.add(new Product("금",15, 750000));
		
		Comparator<Product> comparator = new Comparator<Product>() {

			@Override
			public int compare(Product o1, Product o2) {
				return (int)(o2.unitValue - o1.unitValue);
			}
		};
		
		Collections.sort(s, comparator);
		
		ArrayList<Product> x = new ArrayList<>();
		int w = 0;
		int v = 0;
		
		Product tmp = s.remove(0);
		while(w + tmp.weight <= capacity) {
			x.add(tmp);
			w += tmp.weight;
			v += tmp.value;
			tmp = s.remove(0);
		}
		
		if(capacity - w > 0) {
			int value = (int)((capacity - w) * tmp.unitValue);
			new Product(tmp.name, capacity-w, tmp.value);
			v += value;
		}
		
		System.out.println(x);
		System.out.println(v);
	}
}

class Product{
	String name;
	int weight;
	int value;
	double unitValue;
	
	public Product(String name, int weight, int value) {
		
		this.name = name;
		this.weight = weight;
		this.value = value;
		this.unitValue = (double)value / weight;
	}

	@Override
	public String toString() {
		return String.format("[%s](%d, %d)-%.2f",name,weight,value,unitValue);
	}
	
	
	
	
}
