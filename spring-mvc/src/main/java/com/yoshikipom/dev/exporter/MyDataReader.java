package com.yoshikipom.dev.exporter;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import net.whitbeck.rdbparser.Entry;
import net.whitbeck.rdbparser.KeyValuePair;
import net.whitbeck.rdbparser.RdbParser;

public class MyDataReader implements AutoCloseable {

  public static final int BATCH_SIZE = 10;

  private RdbParser parser;

  public MyDataReader(File file) throws IOException {
    parser = new RdbParser(file);
  }

  public List<KeyValuePair> readBatch() throws IOException {
    List<KeyValuePair> keyValuePairList = new ArrayList<>();

    for (int i = 0; i < BATCH_SIZE; i++) {
      Entry e = parser.readNext();
      if (e == null) {
        return keyValuePairList;
      }
      switch (e.getType()) {
        case KEY_VALUE_PAIR:
          KeyValuePair kvp = (KeyValuePair) e;
          keyValuePairList.add(kvp);
          break;
        case EOF:
          return keyValuePairList;
      }
    }

    return keyValuePairList;
  }

    @Override
    public void close () throws Exception {
      parser.close();
    }
  }
