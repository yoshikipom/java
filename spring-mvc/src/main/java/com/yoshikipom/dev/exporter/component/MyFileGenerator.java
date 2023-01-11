package com.yoshikipom.dev.exporter.component;

import com.yoshikipom.dev.exporter.data.MyData;
import java.io.File;
import java.util.List;

public interface MyFileGenerator {

  File execute(List<MyData> myDataList);
}
