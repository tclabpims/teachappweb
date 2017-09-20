package com.teach.util;

import com.teach.model.SteeringRatesModel;
import com.teach.model.XiModel;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by LiuQi on 2017/9/11.
 */
public class StatUtil {

    /**
     * 统计最值
     * @param steerRateList
     * @param xiList
     * @return
     */
    public static List<XiModel> statExtremeValue(List<SteeringRatesModel> steerRateList, List<XiModel> xiList) {
        if (steerRateList == null || steerRateList.isEmpty()) {
            return xiList;
        }
        int count = 0;
        for (XiModel xiModel : xiList) {
            count++;
            List<SteeringRatesModel> currentSteerRateList = new ArrayList<SteeringRatesModel>();
            for (SteeringRatesModel steeringRatesModel : steerRateList) {
                if (steeringRatesModel.getClassModel() != null &&
                        xiModel.getXiName().equals(steeringRatesModel.getClassModel().getXiName())) {
                    currentSteerRateList.add(steeringRatesModel);
                }
            }
            if (!currentSteerRateList.isEmpty()) {
                double sum = currentSteerRateList.get(0).getTotalRates();
                int max_value;
                int min_value;
                double middle_value;
                double avg_value=0.0;
                for (int i=1; i<currentSteerRateList.size(); i++) {
                    sum = Arith.add(sum, currentSteerRateList.get(i).getTotalRates());
                }
                avg_value = Arith.div(sum, currentSteerRateList.size(), 1);
                //排序，取中位数
                for (int i=0; i<currentSteerRateList.size() - 1; i++) {
                    for (int j = 0; j < currentSteerRateList.size() -  i - 1; j++) {
                        if (currentSteerRateList.get(j).getTotalRates() > currentSteerRateList.get(j + 1).getTotalRates()) {
                            SteeringRatesModel temp = currentSteerRateList.get(j);
                            currentSteerRateList.set(j, currentSteerRateList.get(j + 1));
                            currentSteerRateList.set(j + 1, temp);
                        }
                    }
                }
                if (currentSteerRateList.size() % 2 != 0) {
                    middle_value = currentSteerRateList.get(currentSteerRateList.size() / 2).getTotalRates();
                } else {
                    middle_value =Arith.div((currentSteerRateList.get(currentSteerRateList.size() / 2 - 1).getTotalRates() +
                            currentSteerRateList.get(currentSteerRateList.size() / 2).getTotalRates()), 2.0, 1);
                }
                min_value = currentSteerRateList.get(0).getTotalRates();
                max_value = currentSteerRateList.get(currentSteerRateList.size() - 1).getTotalRates();
                xiModel.setMaxValue(max_value);
                xiModel.setMinValue(min_value);
                xiModel.setAvgValue(avg_value);
                xiModel.setMiddleValue(middle_value);
                xiList.set(count - 1, xiModel);
            }
        }
        return xiList;
    }
}
