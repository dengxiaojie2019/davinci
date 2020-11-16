/*
 * <<
 *  Davinci
 *  ==
 *  Copyright (C) 2016 - 2020 EDP
 *  ==
 *  Licensed under the Apache License, Version 2.0 (the "License");
 *  you may not use this file except in compliance with the License.
 *  You may obtain a copy of the License at
 *        http://www.apache.org/licenses/LICENSE-2.0
 *   Unless required by applicable law or agreed to in writing, software
 *   distributed under the License is distributed on an "AS IS" BASIS,
 *   WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *   See the License for the specific language governing permissions and
 *   limitations under the License.
 *  >>
 *
 */

package edp.davinci.data.enums;

import edp.davinci.data.commons.Constants;

public enum DatabaseTypeEnum {

    MYSQL("mysql", "mysql", "com.mysql.jdbc.Driver", "`", "`", "'", "'"),

    ORACLE("oracle", "oracle", "oracle.jdbc.driver.OracleDriver", "\"", "\"", "\"", "\""),

    SQLSERVER("sqlserver", "sqlserver", "com.microsoft.sqlserver.jdbc.SQLServerDriver", "\"", "\"", "\"", "\""),

    H2("h2", "h2", "org.h2.Driver", "`", "`", "\"", "\""),

    PHOENIX("phoenix", "hbase phoenix", "org.apache.phoenix.jdbc.PhoenixDriver", "", "", "\"", "\""),

    MONGODB("mongo", "mongodb", "mongodb.jdbc.MongoDriver", "`", "`", "\"", "\""),

    ELASTICSEARCH("elasticsearch", "elasticsearch", "com.amazon.opendistroforelasticsearch.jdbc.Driver", "", "", "'", "'"),

    PRESTO("presto", "presto", "com.facebook.presto.jdbc.PrestoDriver", "\"", "\"", "\"", "\""),

    MOONBOX("moonbox", "moonbox", "moonbox.jdbc.MbDriver", "`", "`", "`", "`"),

    CASSANDRA("cassandra", "cassandra", "com.github.adejanovski.cassandra.jdbc.CassandraDriver", "", "", "'", "'"),

    CLICKHOUSE("clickhouse", "clickhouse", "ru.yandex.clickhouse.ClickHouseDriver", "", "", "\"", "\""),

    KYLIN("kylin", "kylin", "org.apache.kylin.jdbc.Driver", "\"", "\"", "\"", "\""),

    VERTICA("vertica", "vertica", "com.vertica.jdbc.Driver", "", "", "'", "'"),

    HANA("sap", "sap hana", "com.sap.db.jdbc.Driver", "", "", "'", "'"),

    IMPALA("impala", "impala", "com.cloudera.impala.jdbc41.Driver", "", "", "'", "'"),

    TDENGINE("TAOS", "TAOS", "com.taosdata.jdbc.TSDBDriver", "'", "'", "\"", "\"");

    private String feature;
    private String desc;
    private String driver;
    private String keywordPrefix;
    private String keywordSuffix;
    private String aliasPrefix;
    private String aliasSuffix;

    DatabaseTypeEnum(String feature, String desc, String driver, String keywordPrefix, String keywordSuffix, String aliasPrefix, String aliasSuffix) {
        this.feature = feature;
        this.desc = desc;
        this.driver = driver;
        this.keywordPrefix = keywordPrefix;
        this.keywordSuffix = keywordSuffix;
        this.aliasPrefix = aliasPrefix;
        this.aliasSuffix = aliasSuffix;
    }

    public static DatabaseTypeEnum urlOf(String url) {
        url = url.toLowerCase().trim();
        for (DatabaseTypeEnum dataTypeEnum : values()) {
            if (url.startsWith(String.format(Constants.JDBC_URL_PREFIX_FORMATTER, dataTypeEnum.feature))) {
                return dataTypeEnum;
            }
        }
        return null;
    }

    public static DatabaseTypeEnum featureOf(String feature) {
        for (DatabaseTypeEnum databaseTypeEnum : values()) {
            if (databaseTypeEnum.getFeature().equals(feature)) {
            	return databaseTypeEnum;
            }
        }
        return null;
    }

    public String getFeature() {
        return feature;
    }

    public String getDesc() {
        return desc;
    }

    public String getDriver() {
        return driver;
    }

    public String getKeywordPrefix() {
        return keywordPrefix;
    }

    public String getKeywordSuffix() {
        return keywordSuffix;
    }

    public String getAliasPrefix() {
        return aliasPrefix;
    }

    public String getAliasSuffix() {
        return aliasSuffix;
    }
}
