using System;
using System.Collections.Generic;
using System.Linq;
using System.Runtime.Serialization;
using System.ServiceModel;
using System.Text;
using System.Text.RegularExpressions;
using System.Xml;

namespace SortByRating
{
    // NOTE: You can use the "Rename" command on the "Refactor" menu to change the class name "sortByRatingService" in code, svc and config file together.
    // NOTE: In order to launch WCF Test Client for testing this service, please select sortByRatingService.svc or sortByRatingService.svc.cs at the Solution Explorer and start debugging.
    public class sortByRatingService : IsortByCrimeDataService
    {
        public string[] sortCitiesByCrimeRate(string cities)
        {
            string[] cityArray = Regex.Split(cities, ",");
            List<CityRankings> l = new List<CityRankings>();
            foreach (string s in cityArray)
            {
                CityRankings c = new CityRankings(s);
                l.Add(c);
            }
            QuickSort q = new QuickSort();
            List<CityRankings> sortedCities = q.sort(l, 0, l.Count-1);
            string[] sortedCityArray = new string[l.Count];
            for (int i = 0; i < sortedCities.Count; i++)
            {
                sortedCityArray[i] = sortedCities.ElementAt<CityRankings>(i).cityName + ", Total Crimes: " + sortedCities.ElementAt<CityRankings>(i).rating;
            }
            return sortedCityArray;
        }
    }

    public class CityRankings
    {
        private string API_KEY = "AIzaSyAYrd6epdfXMbiOdl2_AEHCTwEGDGAxa38";
        public string getAPIKEY() { return this.API_KEY; }
        public int rating;
        public string cityName;
        public CityRankings(string cityName, int rating)
        {
            this.cityName = cityName;
            this.rating = rating;
        }
        public CityRankings(string cityName)
        {
            this.cityName = cityName;
            try
            {
                CrimeDataServiceProxy.CrimeDataServiceClient cdsp = new CrimeDataServiceProxy.CrimeDataServiceClient();
                string baseURL1 = "https://maps.googleapis.com/maps/api/geocode/";
                string query1 = String.Format("xml?address={0}&key={1}", cityName, API_KEY);
                XmlDocument getlatlng = new XmlDocument();
                getlatlng.Load(baseURL1 + query1);
                string lat = "", lng = "";
                XmlNodeList xnl = getlatlng.SelectNodes("/GeocodeResponse/result/geometry");
                foreach (XmlNode xn in xnl)
                {
                    lat = xn["location"]["lat"].InnerText;
                    lng = xn["location"]["lng"].InnerText;
                    break;
                }
                this.rating=cdsp.getTotalCrimes(lat, lng);
            }
            catch (Exception e) 
            { 
                this.rating = 0; 
            }
        }
    }

    public class QuickSort
    {
        public List<CityRankings> sort(List<CityRankings> l, int s, int e)
        {
            if (s >= e)
                return l;
            int p = partition(l, s, e);
            sort(l, s, p - 1);
            sort(l, p + 1, e);
            return l;
        }
        public static int partition(List<CityRankings> l, int s, int e)
        {
            int i = 0;
            int pivot = l.ElementAt<CityRankings>(e).rating;
            for (int j = 0; j < e; j++)
            {
                if (l.ElementAt<CityRankings>(j).rating <= pivot)
                {
                    CityRankings temp = l.ElementAt<CityRankings>(i);
                    
                    l.Insert(i,l.ElementAt<CityRankings>(j));
                    l.RemoveAt(i+1);
                    
                    l.Insert(j, temp);
                    l.RemoveAt(j+1);
                    i++;
                }
            }
            CityRankings temp1 = l.ElementAt<CityRankings>(i);
            
            l.Insert(i, l.ElementAt<CityRankings>(e));
            l.RemoveAt(i+1);
            
            l.Insert(e, temp1);
            l.RemoveAt(e+1);
            return i;
        }
    }
}
