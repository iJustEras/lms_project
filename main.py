import pandas as pd

# Sample data
data = {
    'values': [7.0, 6.2, 7.7, 8.0, 6.4, 6.2, 7.2, 5.4, 6.4, 6.5, 7.2, 5.4, 5.2]
}

df = pd.DataFrame(data)

# Mean
mean_value = df['values'].mean()

# Median
median_value = df['values'].median()

# Mode (can return multiple values)
mode_value = df['values'].mode()

print("Mean:", mean_value)
print("Median:", median_value)
print("Mode:", mode_value.tolist())


print(sorted(data['values']))

a = [2, 5, 7, 9, 8]
b = [6, 15, 21, 27, 24]

print(sum(a) / 5, sum(b) / 5)
