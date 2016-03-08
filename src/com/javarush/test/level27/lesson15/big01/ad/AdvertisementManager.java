//package com.javarush.test.level27.lesson15.big01.ad;
//
//import com.javarush.test.level27.lesson15.big01.ConsoleHelper;
//import com.javarush.test.level27.lesson15.big01.statistic.StatisticEventManager;
//import com.javarush.test.level27.lesson15.big01.statistic.event.NoAvailableVideoEventDataRow;
//import com.javarush.test.level27.lesson15.big01.statistic.event.VideoSelectedEventDataRow;
//
//import java.util.*;
//
//public class AdvertisementManager
//{
//    private final AdvertisementStorage storage = AdvertisementStorage.getInstance();
//    private int timeSeconds;
//    public AdvertisementManager(int timeSeconds)
//    {
//        this.timeSeconds = timeSeconds;
//    }
//    public void processVideos()
//    {
//        List<Advertisement> selected = selection();
//        if (selected.isEmpty())
//        {
//            StatisticEventManager.getInstance().register(new NoAvailableVideoEventDataRow(timeSeconds));
//            throw new NoVideoAvailableException();
//        }
//        Collections.sort(selected, new Comparator<Advertisement>()
//        {
//            @Override
//            public int compare(Advertisement o1, Advertisement o2)
//            {
//                long differenceProceeds = o2.getAmountPerOneDisplaying() - o1.getAmountPerOneDisplaying();
//                if (differenceProceeds != 0)
//                {
//                    return (int)differenceProceeds;
//                }
//                else
//                {
//                    int proceedsPerSecond1 = (int) (1000 * ((double) o1.getAmountPerOneDisplaying() / o1.getDuration()));
//                    int proceedsPerSecond2 = (int) (1000 * ((double) o2.getAmountPerOneDisplaying() / o2.getDuration()));
//                    return proceedsPerSecond1 - proceedsPerSecond2;
//                }
//            }
//        });
//
//        long amount = 0;
//        int duration = 0;
//        for (Advertisement ad : selected) {
//            amount += ad.getAmountPerOneDisplaying();
//            duration += ad.getDuration();
//        }
//        StatisticEventManager.getInstance().register(new VideoSelectedEventDataRow(selected, amount, duration));
//
//        for (Advertisement advertisement : selected)
//        {
//            String pattern = "%s is displaying... %s, %s";
//            String proceeds = String.valueOf(advertisement.getAmountPerOneDisplaying());
//            String proceedsPerOneSecond = String.valueOf((int)(1000 * (double) advertisement.getAmountPerOneDisplaying()
//                    / advertisement.getDuration()));
//            ConsoleHelper.writeMessage(String.format(pattern, advertisement.getName(), proceeds, proceedsPerOneSecond));
//            advertisement.revalidate();
//        }
//    }
//    private List<Advertisement> selection()
//    {
//        Map<List<Advertisement>, Long> results = new HashMap<>();
//        List<Advertisement> temp = new ArrayList<>();
//        for (Advertisement iter : storage.list()) {
//            if (iter.getHits() > 0) {
//                temp.add(iter);
//            }
//        }
//        Advertisement[] arr = temp.toArray(new Advertisement[temp.size()]);
//        for (int i = 0; i < arr.length; i++)
//        {
//            search(arr, i, 0, 0, new ArrayList<Advertisement>(), results);
//        }
//        List<Advertisement> standardList = new ArrayList<>();
//        long standardProceeds = 0;
//        for (Map.Entry<List<Advertisement>, Long> pair : results.entrySet())
//        {
//            if (standardProceeds < pair.getValue())
//            {
//                standardList = pair.getKey();
//                standardProceeds = pair.getValue();
//            }
//            else if (standardProceeds == pair.getValue())
//            {
//                int standardDuration = 0;
//                for (Advertisement advertisement : standardList)
//                {
//                    standardDuration += advertisement.getDuration();
//                }
//                int currentDuration = 0;
//                for (Advertisement advertisement : pair.getKey())
//                {
//                    currentDuration += advertisement.getDuration();
//                }
//                if ((standardDuration < currentDuration) || (standardDuration == currentDuration && standardList.size() > pair.getKey().size()))
//                {
//                    standardList = pair.getKey();
//                    standardProceeds = pair.getValue();
//                }
//            }
//        }
//        return standardList;
//    }
//    private void search(Advertisement[] advertisements, int pos, int duration, long proceeds, List<Advertisement> result,
//                        Map<List<Advertisement>, Long> results)
//    {
//        duration += advertisements[pos].getDuration();
//        proceeds += advertisements[pos].getAmountPerOneDisplaying();
//        if (duration > timeSeconds)
//        {
//            proceeds -= advertisements[pos].getAmountPerOneDisplaying();
//            results.put(result, proceeds);
//        }
//        else
//        {
//            result.add(advertisements[pos]);
//            if (pos == advertisements.length - 1)
//            {
//                results.put(result, proceeds);
//                return;
//            }
//            for (int i = pos + 1; i < advertisements.length; i++)
//            {
//                search(advertisements, i, duration, proceeds, new ArrayList<Advertisement>(result), results);
//            }
//        }
//    }
//}
