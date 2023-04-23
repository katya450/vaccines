When interested in just the status at the moment:

`(quantities data-with-keys)`

=>  

```
({:vaccine "Pfizer", :quantity-remaining 2600} {:vaccine "AstraZeneca", :quantity-remaining 1700})
```


Or if interested in daily status, uncomment the print and get somewhat an ugly but accurate log (with multiple dates still) :D

```
{:vaccine Pfizer, :batch_date 2021-09-01, :remaining 1500}
{:vaccine Pfizer, :batch_date 2021-09-02, :remaining 3700}
{:vaccine Pfizer, :batch_date 2021-09-02, :remaining 2900}
{:vaccine Pfizer, :batch_date 2021-09-03, :remaining 2600}
{:vaccine Pfizer, :batch_date 2021-09-04, :remaining 3700}
{:vaccine Pfizer, :batch_date 2021-09-04, :remaining 3000}
{:vaccine Pfizer, :batch_date 2021-09-05, :remaining 2600}
({:vaccine "Pfizer", :quantity-remaining 2600}{:vaccine AstraZeneca, :batch_date 2021-09-02, :remaining 900}
{:vaccine AstraZeneca, :batch_date 2021-09-02, :remaining 700}
{:vaccine AstraZeneca, :batch_date 2021-09-03, :remaining 1400}
{:vaccine AstraZeneca, :batch_date 2021-09-04, :remaining 1900}
{:vaccine AstraZeneca, :batch_date 2021-09-05, :remaining 1700}
 {:vaccine "AstraZeneca", :quantity-remaining 1700})
```