
	
	import java.util.Scanner;
	class Item {
	int weight;
	int value;
	public Item(int weight, int value) {
	this.weight = weight;
	this.value = value;
	}
	}
	class FractionalKnapsack {
	public static double getMaxValue(int[] weights, int[] values, int capacity) {
	int n = weights.length;
	Item[] items = new Item[n];
	for (int i = 0; i < n; i++) {
		items[i] = new Item(weights[i], values[i]);
	}
	for (int i = 0; i < n - 1; i++) {
	for (int j = i + 1; j < n; j++) {
	if ((double) items[i].value / items[i].weight < (double) items[j].value /
	items[j].weight) {
	Item temp = items[i];
	items[i] = items[j];
	items[j] = temp;
	}
	}
	}
	double totalValue = 0;
	int currentWeight = 0;
	for (Item item : items) {
	if (currentWeight + item.weight <= capacity) {
	currentWeight += item.weight;
	totalValue += item.value;
	} else {
	int remainingCapacity = capacity - currentWeight;
	totalValue += (double) item.value * remainingCapacity / item.weight;
	break;
	}
	}
	return totalValue;
	}
	public static void main(String[] args) {
	Scanner scanner = new Scanner(System.in);
	System.out.print("Enter the number of items: ");
	int n = scanner.nextInt();
	int[] weights = new int[n];
	int[] values = new int[n];
	System.out.println("Enter weights and values for each item:");
	for (int i = 0; i < n; i++) {
	weights[i] = scanner.nextInt();
	values[i] = scanner.nextInt();
	}
	System.out.print("Enter the capacity of the knapsack: ");
	int capacity = scanner.nextInt();
	double maxValue = getMaxValue(weights, values, capacity);
	System.out.println("Maximum value in Knapsack = " + maxValue);
	}
	}

	
	
	
