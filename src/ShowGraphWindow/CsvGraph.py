from matplotlib import pyplot as plt
import pandas as pd

class CsvGraph:
    def __init__(self, csv_path, out_png):
        self.csv_path = csv_path
        self.out_png = out_png
    
    def create_new_graph(self):
        df = pd.read_csv(self.csv_path, parse_dates=["DATE"])
        
        df.sort_values("DATE", inplace=True)
        plt.plot(df["DATE"], df["WEIGHT"], marker="o", label="Weight")
        plt.xlabel("Date")
        plt.ylabel("Weight (kg)")
        plt.title("Weight Change Over Time")
        plt.legend()
        plt.xticks(rotation=45)
        plt.grid(True)
        plt.tight_layout()
        plt.show()

if __name__ == "__main__":
    import sys

    csv_path = sys.argv[1]
    out_png = sys.argv[2]

    newGraph = CsvGraph(csv_path, out_png)
    newGraph.create_new_graph()