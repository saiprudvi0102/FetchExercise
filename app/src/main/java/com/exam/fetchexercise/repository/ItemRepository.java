package com.exam.fetchexercise.repository;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import com.exam.fetchexercise.model.Item;
import com.exam.fetchexercise.network.ApiClient;
import com.exam.fetchexercise.network.ApiService;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class ItemRepository {
    private final MutableLiveData<List<Item>> itemsLiveData = new MutableLiveData<>();

    public void fetchItems() {
        ApiService api = ApiClient.getClient().create(ApiService.class);

        api.getItems().enqueue(new Callback<>() {
            @Override
            public void onResponse(Call<List<Item>> call, Response<List<Item>> response) {
                if (response.isSuccessful() && response.body() != null) {
                    List<Item> allItems = response.body();
                    List<Item> filteredItems = filterItems(allItems);
                    List<Item> sortedItems = sortItems(filteredItems);
                    itemsLiveData.postValue(sortedItems);
                } else {
                    itemsLiveData.postValue(new ArrayList<>());
                }
            }

            @Override
            public void onFailure(Call<List<Item>> call, Throwable t) {
                itemsLiveData.postValue(new ArrayList<>());
            }
        });
    }

    private List<Item> filterItems(List<Item> items) {
        List<Item> result = new ArrayList<>();
        for (Item item : items) {
            if (item.getName() != null && !item.getName().trim().isEmpty()) {
                result.add(item);
            }
        }
        return result;
    }

    private List<Item> sortItems(List<Item> items) {
        Collections.sort(items, (item1, item2) -> {
            if (item1.getListId() != item2.getListId()) {
                return Integer.compare(item1.getListId(), item2.getListId());
            }

            String name1 = item1.getName();
            String name2 = item2.getName();

            Integer num1 = extractNumber(name1);
            Integer num2 = extractNumber(name2);

            if (num1 != null && num2 != null) {
                return num1.compareTo(num2);
            }

            if (num1 != null) return -1;
            if (num2 != null) return 1;

            return name1.compareToIgnoreCase(name2);
        });
        return items;
    }

    private Integer extractNumber(String str) {
        if (str == null) return null;
        try {
            String numStr = str.replaceAll("\\D+", "");
            return numStr.isEmpty() ? null : Integer.parseInt(numStr);
        } catch (NumberFormatException e) {
            return null;
        }
    }

    public LiveData<List<Item>> getItemsLiveData() {
        return itemsLiveData;
    }
}