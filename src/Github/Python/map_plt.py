import json
import pandas as pd
import plotly.express as px
from plotly.graph_objs import *





with open("/Users/fsociety/PycharmProjects/untitled1/Seaborn_Datasets/custom_geo.json", 'r') as f:
        counties = json.load(f)


def mean_price(data):
    data = wine.groupby(['country']).mean()
    data = data.reset_index()
    return data


def show_plot(data):
    fig = px.choropleth_mapbox(data, geojson=counties, locations='country', color='price',
                               color_continuous_scale="Viridis",
                               # range_color=(0, 12),
                               mapbox_style="carto-positron",
                               featureidkey="properties.name_long",
                               zoom=3, center={"lat": 37.0902, "lon": -95.7129},
                               opacity=0.5,
                               labels={'unemp': 'unemployment rate'}
                               )
    fig.update_layout(margin={"r": 0, "t": 0, "l": 0, "b": 0})
    fig.show()





def read_dataset(dataset):
    folder = "Seaborn_Datasets/"
    data = pd.read_csv(folder + dataset)
    return data


wine = read_dataset("wine1.csv")




# wine = pd.str.replace('US', 'United States')
wine = wine.replace('US', 'United States')
# sort = wine.query('variety == "Cabernet Sauvignon" and country == "Italy"')
sort = wine.query('variety == "Cabernet Sauvignon"')
sort = sort.drop('description', axis=1)

data = mean_price(wine)

fig = px.choropleth_mapbox(data, geojson=counties, locations='country', color='price',
                           color_continuous_scale="Viridis",
                           # range_color=(0, 12),
                           mapbox_style="carto-positron",
                           featureidkey="properties.name_long",
                           zoom=3, center={"lat": 37.0902, "lon": -95.7129},
                           opacity=0.5,
                           labels={'unemp': 'unemployment rate'}
                           )
fig.update_layout(margin={"r": 0, "t": 0, "l": 0, "b": 0})
# fig.show()

# px.offline.plot(fig, filename='name.html')
fig.write_html("name.html")


print(counties["features"][1]["properties"]["name_long"])
print(counties["features"][1])


