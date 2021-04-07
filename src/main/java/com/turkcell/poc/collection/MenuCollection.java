package com.turkcell.poc.collection;

import com.turkcell.poc.base.BaseCollection;
import lombok.Data;
import lombok.experimental.Accessors;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "menu")
@Data
@Accessors(chain = true)
public class MenuCollection extends BaseCollection {
    @Id
    private String id;

    private String title;
}
