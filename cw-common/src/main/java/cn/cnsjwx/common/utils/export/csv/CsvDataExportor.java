package cn.cnsjwx.common.utils.export.csv;

import java.io.OutputStream;

import cn.cnsjwx.common.utils.export.DataField;
import cn.cnsjwx.common.utils.export.ExportDataSource;
import cn.cnsjwx.common.utils.export.txt.TxtDataExportor;


/**
 * 描述: csv格式数据导出工具
 * @author Hill
 *
 */
public class CsvDataExportor<T> extends TxtDataExportor<T> {
	public CsvDataExportor(DataField[] fields, ExportDataSource<T> dataSource,OutputStream os) {
		super(fields, dataSource, os,",");
	}
}
