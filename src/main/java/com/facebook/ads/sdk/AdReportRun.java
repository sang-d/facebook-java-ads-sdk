/**
 * Copyright (c) 2015-present, Facebook, Inc. All rights reserved.
 *
 * You are hereby granted a non-exclusive, worldwide, royalty-free license to
 * use, copy, modify, and distribute this software in source code or binary
 * form for use in connection with the web services and APIs provided by
 * Facebook.
 *
 * As with any software that integrates with the Facebook platform, your use
 * of this software is subject to the Facebook Developer Principles and
 * Policies [http://developers.facebook.com/policy/]. This copyright notice
 * shall be included in all copies or substantial portions of the software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL
 * THE AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING
 * FROM, OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER
 * DEALINGS IN THE SOFTWARE.
 *
 */

package com.facebook.ads.sdk;

import java.io.File;
import java.lang.reflect.Modifier;
import java.lang.reflect.Type;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.google.gson.JsonObject;
import com.google.gson.JsonArray;
import com.google.gson.annotations.SerializedName;
import com.google.gson.reflect.TypeToken;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonElement;
import com.google.gson.JsonParser;

import com.facebook.ads.sdk.APIException.MalformedResponseException;

/**
 * This class is auto-genereated.
 *
 * For any issues or feature requests related to this class, please let us know
 * on github and we'll fix in our codegen framework. We'll not be able to accept
 * pull request for this class.
 *
 */
public class AdReportRun extends APINode {
  @SerializedName("account_id")
  private String mAccountId = null;
  @SerializedName("async_percent_completion")
  private Long mAsyncPercentCompletion = null;
  @SerializedName("async_status")
  private String mAsyncStatus = null;
  @SerializedName("date_start")
  private String mDateStart = null;
  @SerializedName("date_stop")
  private String mDateStop = null;
  @SerializedName("emails")
  private List<String> mEmails = null;
  @SerializedName("friendly_name")
  private String mFriendlyName = null;
  @SerializedName("id")
  private String mId = null;
  @SerializedName("is_bookmarked")
  private Boolean mIsBookmarked = null;
  @SerializedName("is_running")
  private Boolean mIsRunning = null;
  @SerializedName("schedule_id")
  private String mScheduleId = null;
  @SerializedName("time_completed")
  private Long mTimeCompleted = null;
  @SerializedName("time_ref")
  private Long mTimeRef = null;
  protected static Gson gson = null;

  AdReportRun() {
  }

  public AdReportRun(Long id, APIContext context) {
    this(id.toString(), context);
  }

  public AdReportRun(String id, APIContext context) {
    this.mId = id;
    this.context = context;
  }

  public AdReportRun fetch() throws APIException{
    AdReportRun newInstance = fetchById(this.getPrefixedId().toString(), this.context);
    this.copyFrom(newInstance);
    return this;
  }

  public static AdReportRun fetchById(Long id, APIContext context) throws APIException {
    return fetchById(id.toString(), context);
  }

  public static AdReportRun fetchById(String id, APIContext context) throws APIException {
    AdReportRun adReportRun =
      new APIRequestGet(id, context)
      .requestAllFields()
      .execute();
    return adReportRun;
  }

  public static APINodeList<AdReportRun> fetchByIds(List<String> ids, List<String> fields, APIContext context) throws APIException {
    return (APINodeList<AdReportRun>)(
      new APIRequest<AdReportRun>(context, "", "/", "GET", AdReportRun.getParser())
        .setParam("ids", String.join(",", ids))
        .requestFields(fields)
        .execute()
    );
  }

  private String getPrefixedId() {
    return getId();
  }

  public String getId() {
    return getFieldId().toString();
  }
  public static AdReportRun loadJSON(String json, APIContext context) {
    AdReportRun adReportRun = getGson().fromJson(json, AdReportRun.class);
    if (context.isDebug()) {
      JsonParser parser = new JsonParser();
      JsonElement o1 = parser.parse(json);
      JsonElement o2 = parser.parse(adReportRun.toString());
      if (o1.getAsJsonObject().get("__fb_trace_id__") != null) {
        o2.getAsJsonObject().add("__fb_trace_id__", o1.getAsJsonObject().get("__fb_trace_id__"));
      }
      if (!o1.equals(o2)) {
        context.log("[Warning] When parsing response, object is not consistent with JSON:");
        context.log("[JSON]" + o1);
        context.log("[Object]" + o2);
      };
    }
    adReportRun.context = context;
    adReportRun.rawValue = json;
    JsonParser parser = new JsonParser();
    JsonObject o = parser.parse(json).getAsJsonObject();
    String reportRunId = null;
    if (o.has("report_run_id")) {
      reportRunId = o.get("report_run_id").getAsString();
      if (reportRunId != null) {
        adReportRun.mId = reportRunId;
      }
    }
    return adReportRun;
  }

  public static APINodeList<AdReportRun> parseResponse(String json, APIContext context, APIRequest request) throws MalformedResponseException {
    APINodeList<AdReportRun> adReportRuns = new APINodeList<AdReportRun>(request, json);
    JsonArray arr;
    JsonObject obj;
    JsonParser parser = new JsonParser();
    Exception exception = null;
    try{
      JsonElement result = parser.parse(json);
      if (result.isJsonArray()) {
        // First, check if it's a pure JSON Array
        arr = result.getAsJsonArray();
        for (int i = 0; i < arr.size(); i++) {
          adReportRuns.add(loadJSON(arr.get(i).getAsJsonObject().toString(), context));
        };
        return adReportRuns;
      } else if (result.isJsonObject()) {
        obj = result.getAsJsonObject();
        if (obj.has("data")) {
          if (obj.has("paging")) {
            JsonObject paging = obj.get("paging").getAsJsonObject().get("cursors").getAsJsonObject();
            String before = paging.has("before") ? paging.get("before").getAsString() : null;
            String after = paging.has("after") ? paging.get("after").getAsString() : null;
            adReportRuns.setPaging(before, after);
          }
          if (obj.get("data").isJsonArray()) {
            // Second, check if it's a JSON array with "data"
            arr = obj.get("data").getAsJsonArray();
            for (int i = 0; i < arr.size(); i++) {
              adReportRuns.add(loadJSON(arr.get(i).getAsJsonObject().toString(), context));
            };
          } else if (obj.get("data").isJsonObject()) {
            // Third, check if it's a JSON object with "data"
            obj = obj.get("data").getAsJsonObject();
            boolean isRedownload = false;
            for (String s : new String[]{"campaigns", "adsets", "ads"}) {
              if (obj.has(s)) {
                isRedownload = true;
                obj = obj.getAsJsonObject(s);
                for (Map.Entry<String, JsonElement> entry : obj.entrySet()) {
                  adReportRuns.add(loadJSON(entry.getValue().toString(), context));
                }
                break;
              }
            }
            if (!isRedownload) {
              adReportRuns.add(loadJSON(obj.toString(), context));
            }
          }
          return adReportRuns;
        } else if (obj.has("images")) {
          // Fourth, check if it's a map of image objects
          obj = obj.get("images").getAsJsonObject();
          for (Map.Entry<String, JsonElement> entry : obj.entrySet()) {
              adReportRuns.add(loadJSON(entry.getValue().toString(), context));
          }
          return adReportRuns;
        } else {
          // Fifth, check if it's an array of objects indexed by id
          boolean isIdIndexedArray = true;
          for (Map.Entry entry : obj.entrySet()) {
            String key = (String) entry.getKey();
            if (key.equals("__fb_trace_id__")) {
              continue;
            }
            JsonElement value = (JsonElement) entry.getValue();
            if (
              value != null &&
              value.isJsonObject() &&
              value.getAsJsonObject().has("id") &&
              value.getAsJsonObject().get("id") != null &&
              value.getAsJsonObject().get("id").getAsString().equals(key)
            ) {
              adReportRuns.add(loadJSON(value.toString(), context));
            } else {
              isIdIndexedArray = false;
              break;
            }
          }
          if (isIdIndexedArray) {
            return adReportRuns;
          }

          // Sixth, check if it's pure JsonObject
          adReportRuns.clear();
          adReportRuns.add(loadJSON(json, context));
          return adReportRuns;
        }
      }
    } catch (Exception e) {
      exception = e;
    }
    throw new MalformedResponseException(
      "Invalid response string: " + json,
      exception
    );
  }

  @Override
  public APIContext getContext() {
    return context;
  }

  @Override
  public void setContext(APIContext context) {
    this.context = context;
  }

  @Override
  public String toString() {
    return getGson().toJson(this);
  }

  public APIRequestGetInsights getInsights() {
    return new APIRequestGetInsights(this.getPrefixedId().toString(), context);
  }

  public APIRequestGet get() {
    return new APIRequestGet(this.getPrefixedId().toString(), context);
  }


  public String getFieldAccountId() {
    return mAccountId;
  }

  public Long getFieldAsyncPercentCompletion() {
    return mAsyncPercentCompletion;
  }

  public String getFieldAsyncStatus() {
    return mAsyncStatus;
  }

  public String getFieldDateStart() {
    return mDateStart;
  }

  public String getFieldDateStop() {
    return mDateStop;
  }

  public List<String> getFieldEmails() {
    return mEmails;
  }

  public String getFieldFriendlyName() {
    return mFriendlyName;
  }

  public String getFieldId() {
    return mId;
  }

  public Boolean getFieldIsBookmarked() {
    return mIsBookmarked;
  }

  public Boolean getFieldIsRunning() {
    return mIsRunning;
  }

  public String getFieldScheduleId() {
    return mScheduleId;
  }

  public Long getFieldTimeCompleted() {
    return mTimeCompleted;
  }

  public Long getFieldTimeRef() {
    return mTimeRef;
  }



  public static class APIRequestGetInsights extends APIRequest<AdsInsights> {

    APINodeList<AdsInsights> lastResponse = null;
    @Override
    public APINodeList<AdsInsights> getLastResponse() {
      return lastResponse;
    }
    public static final String[] PARAMS = {
    };

    public static final String[] FIELDS = {
      "account_id",
      "account_name",
      "action_values",
      "actions",
      "ad_id",
      "ad_name",
      "adset_id",
      "adset_name",
      "app_store_clicks",
      "buying_type",
      "call_to_action_clicks",
      "campaign_id",
      "campaign_name",
      "canvas_avg_view_percent",
      "canvas_avg_view_time",
      "clicks",
      "cost_per_10_sec_video_view",
      "cost_per_action_type",
      "cost_per_estimated_ad_recallers",
      "cost_per_inline_link_click",
      "cost_per_inline_post_engagement",
      "cost_per_total_action",
      "cost_per_unique_action_type",
      "cost_per_unique_click",
      "cost_per_unique_inline_link_click",
      "cpc",
      "cpm",
      "cpp",
      "ctr",
      "date_start",
      "date_stop",
      "deeplink_clicks",
      "estimated_ad_recall_rate",
      "estimated_ad_recallers",
      "frequency",
      "impressions",
      "inline_link_click_ctr",
      "inline_link_clicks",
      "inline_post_engagement",
      "newsfeed_avg_position",
      "newsfeed_clicks",
      "newsfeed_impressions",
      "objective",
      "place_page_name",
      "reach",
      "relevance_score",
      "social_clicks",
      "social_impressions",
      "social_reach",
      "social_spend",
      "spend",
      "total_action_value",
      "total_actions",
      "total_unique_actions",
      "unique_actions",
      "unique_clicks",
      "unique_ctr",
      "unique_impressions",
      "unique_inline_link_click_ctr",
      "unique_inline_link_clicks",
      "unique_link_clicks_ctr",
      "unique_social_clicks",
      "unique_social_impressions",
      "video_10_sec_watched_actions",
      "video_15_sec_watched_actions",
      "video_30_sec_watched_actions",
      "video_avg_pct_watched_actions",
      "video_avg_percent_watched_actions",
      "video_avg_sec_watched_actions",
      "video_avg_time_watched_actions",
      "video_complete_watched_actions",
      "video_p100_watched_actions",
      "video_p25_watched_actions",
      "video_p50_watched_actions",
      "video_p75_watched_actions",
      "video_p95_watched_actions",
      "website_clicks",
      "website_ctr",
    };

    @Override
    public APINodeList<AdsInsights> parseResponse(String response) throws APIException {
      return AdsInsights.parseResponse(response, getContext(), this);
    }

    @Override
    public APINodeList<AdsInsights> execute() throws APIException {
      return execute(new HashMap<String, Object>());
    }

    @Override
    public APINodeList<AdsInsights> execute(Map<String, Object> extraParams) throws APIException {
      lastResponse = parseResponse(executeInternal(extraParams));
      return lastResponse;
    }

    public APIRequestGetInsights(String nodeId, APIContext context) {
      super(context, nodeId, "/insights", "GET", Arrays.asList(PARAMS));
    }

    @Override
    public APIRequestGetInsights setParam(String param, Object value) {
      setParamInternal(param, value);
      return this;
    }

    @Override
    public APIRequestGetInsights setParams(Map<String, Object> params) {
      setParamsInternal(params);
      return this;
    }


    public APIRequestGetInsights requestAllFields () {
      return this.requestAllFields(true);
    }

    public APIRequestGetInsights requestAllFields (boolean value) {
      for (String field : FIELDS) {
        this.requestField(field, value);
      }
      return this;
    }

    @Override
    public APIRequestGetInsights requestFields (List<String> fields) {
      return this.requestFields(fields, true);
    }

    @Override
    public APIRequestGetInsights requestFields (List<String> fields, boolean value) {
      for (String field : fields) {
        this.requestField(field, value);
      }
      return this;
    }

    @Override
    public APIRequestGetInsights requestField (String field) {
      this.requestField(field, true);
      return this;
    }

    @Override
    public APIRequestGetInsights requestField (String field, boolean value) {
      this.requestFieldInternal(field, value);
      return this;
    }

    public APIRequestGetInsights requestAccountIdField () {
      return this.requestAccountIdField(true);
    }
    public APIRequestGetInsights requestAccountIdField (boolean value) {
      this.requestField("account_id", value);
      return this;
    }
    public APIRequestGetInsights requestAccountNameField () {
      return this.requestAccountNameField(true);
    }
    public APIRequestGetInsights requestAccountNameField (boolean value) {
      this.requestField("account_name", value);
      return this;
    }
    public APIRequestGetInsights requestActionValuesField () {
      return this.requestActionValuesField(true);
    }
    public APIRequestGetInsights requestActionValuesField (boolean value) {
      this.requestField("action_values", value);
      return this;
    }
    public APIRequestGetInsights requestActionsField () {
      return this.requestActionsField(true);
    }
    public APIRequestGetInsights requestActionsField (boolean value) {
      this.requestField("actions", value);
      return this;
    }
    public APIRequestGetInsights requestAdIdField () {
      return this.requestAdIdField(true);
    }
    public APIRequestGetInsights requestAdIdField (boolean value) {
      this.requestField("ad_id", value);
      return this;
    }
    public APIRequestGetInsights requestAdNameField () {
      return this.requestAdNameField(true);
    }
    public APIRequestGetInsights requestAdNameField (boolean value) {
      this.requestField("ad_name", value);
      return this;
    }
    public APIRequestGetInsights requestAdsetIdField () {
      return this.requestAdsetIdField(true);
    }
    public APIRequestGetInsights requestAdsetIdField (boolean value) {
      this.requestField("adset_id", value);
      return this;
    }
    public APIRequestGetInsights requestAdsetNameField () {
      return this.requestAdsetNameField(true);
    }
    public APIRequestGetInsights requestAdsetNameField (boolean value) {
      this.requestField("adset_name", value);
      return this;
    }
    public APIRequestGetInsights requestAppStoreClicksField () {
      return this.requestAppStoreClicksField(true);
    }
    public APIRequestGetInsights requestAppStoreClicksField (boolean value) {
      this.requestField("app_store_clicks", value);
      return this;
    }
    public APIRequestGetInsights requestBuyingTypeField () {
      return this.requestBuyingTypeField(true);
    }
    public APIRequestGetInsights requestBuyingTypeField (boolean value) {
      this.requestField("buying_type", value);
      return this;
    }
    public APIRequestGetInsights requestCallToActionClicksField () {
      return this.requestCallToActionClicksField(true);
    }
    public APIRequestGetInsights requestCallToActionClicksField (boolean value) {
      this.requestField("call_to_action_clicks", value);
      return this;
    }
    public APIRequestGetInsights requestCampaignIdField () {
      return this.requestCampaignIdField(true);
    }
    public APIRequestGetInsights requestCampaignIdField (boolean value) {
      this.requestField("campaign_id", value);
      return this;
    }
    public APIRequestGetInsights requestCampaignNameField () {
      return this.requestCampaignNameField(true);
    }
    public APIRequestGetInsights requestCampaignNameField (boolean value) {
      this.requestField("campaign_name", value);
      return this;
    }
    public APIRequestGetInsights requestCanvasAvgViewPercentField () {
      return this.requestCanvasAvgViewPercentField(true);
    }
    public APIRequestGetInsights requestCanvasAvgViewPercentField (boolean value) {
      this.requestField("canvas_avg_view_percent", value);
      return this;
    }
    public APIRequestGetInsights requestCanvasAvgViewTimeField () {
      return this.requestCanvasAvgViewTimeField(true);
    }
    public APIRequestGetInsights requestCanvasAvgViewTimeField (boolean value) {
      this.requestField("canvas_avg_view_time", value);
      return this;
    }
    public APIRequestGetInsights requestClicksField () {
      return this.requestClicksField(true);
    }
    public APIRequestGetInsights requestClicksField (boolean value) {
      this.requestField("clicks", value);
      return this;
    }
    public APIRequestGetInsights requestCostPer10SecVideoViewField () {
      return this.requestCostPer10SecVideoViewField(true);
    }
    public APIRequestGetInsights requestCostPer10SecVideoViewField (boolean value) {
      this.requestField("cost_per_10_sec_video_view", value);
      return this;
    }
    public APIRequestGetInsights requestCostPerActionTypeField () {
      return this.requestCostPerActionTypeField(true);
    }
    public APIRequestGetInsights requestCostPerActionTypeField (boolean value) {
      this.requestField("cost_per_action_type", value);
      return this;
    }
    public APIRequestGetInsights requestCostPerEstimatedAdRecallersField () {
      return this.requestCostPerEstimatedAdRecallersField(true);
    }
    public APIRequestGetInsights requestCostPerEstimatedAdRecallersField (boolean value) {
      this.requestField("cost_per_estimated_ad_recallers", value);
      return this;
    }
    public APIRequestGetInsights requestCostPerInlineLinkClickField () {
      return this.requestCostPerInlineLinkClickField(true);
    }
    public APIRequestGetInsights requestCostPerInlineLinkClickField (boolean value) {
      this.requestField("cost_per_inline_link_click", value);
      return this;
    }
    public APIRequestGetInsights requestCostPerInlinePostEngagementField () {
      return this.requestCostPerInlinePostEngagementField(true);
    }
    public APIRequestGetInsights requestCostPerInlinePostEngagementField (boolean value) {
      this.requestField("cost_per_inline_post_engagement", value);
      return this;
    }
    public APIRequestGetInsights requestCostPerTotalActionField () {
      return this.requestCostPerTotalActionField(true);
    }
    public APIRequestGetInsights requestCostPerTotalActionField (boolean value) {
      this.requestField("cost_per_total_action", value);
      return this;
    }
    public APIRequestGetInsights requestCostPerUniqueActionTypeField () {
      return this.requestCostPerUniqueActionTypeField(true);
    }
    public APIRequestGetInsights requestCostPerUniqueActionTypeField (boolean value) {
      this.requestField("cost_per_unique_action_type", value);
      return this;
    }
    public APIRequestGetInsights requestCostPerUniqueClickField () {
      return this.requestCostPerUniqueClickField(true);
    }
    public APIRequestGetInsights requestCostPerUniqueClickField (boolean value) {
      this.requestField("cost_per_unique_click", value);
      return this;
    }
    public APIRequestGetInsights requestCostPerUniqueInlineLinkClickField () {
      return this.requestCostPerUniqueInlineLinkClickField(true);
    }
    public APIRequestGetInsights requestCostPerUniqueInlineLinkClickField (boolean value) {
      this.requestField("cost_per_unique_inline_link_click", value);
      return this;
    }
    public APIRequestGetInsights requestCpcField () {
      return this.requestCpcField(true);
    }
    public APIRequestGetInsights requestCpcField (boolean value) {
      this.requestField("cpc", value);
      return this;
    }
    public APIRequestGetInsights requestCpmField () {
      return this.requestCpmField(true);
    }
    public APIRequestGetInsights requestCpmField (boolean value) {
      this.requestField("cpm", value);
      return this;
    }
    public APIRequestGetInsights requestCppField () {
      return this.requestCppField(true);
    }
    public APIRequestGetInsights requestCppField (boolean value) {
      this.requestField("cpp", value);
      return this;
    }
    public APIRequestGetInsights requestCtrField () {
      return this.requestCtrField(true);
    }
    public APIRequestGetInsights requestCtrField (boolean value) {
      this.requestField("ctr", value);
      return this;
    }
    public APIRequestGetInsights requestDateStartField () {
      return this.requestDateStartField(true);
    }
    public APIRequestGetInsights requestDateStartField (boolean value) {
      this.requestField("date_start", value);
      return this;
    }
    public APIRequestGetInsights requestDateStopField () {
      return this.requestDateStopField(true);
    }
    public APIRequestGetInsights requestDateStopField (boolean value) {
      this.requestField("date_stop", value);
      return this;
    }
    public APIRequestGetInsights requestDeeplinkClicksField () {
      return this.requestDeeplinkClicksField(true);
    }
    public APIRequestGetInsights requestDeeplinkClicksField (boolean value) {
      this.requestField("deeplink_clicks", value);
      return this;
    }
    public APIRequestGetInsights requestEstimatedAdRecallRateField () {
      return this.requestEstimatedAdRecallRateField(true);
    }
    public APIRequestGetInsights requestEstimatedAdRecallRateField (boolean value) {
      this.requestField("estimated_ad_recall_rate", value);
      return this;
    }
    public APIRequestGetInsights requestEstimatedAdRecallersField () {
      return this.requestEstimatedAdRecallersField(true);
    }
    public APIRequestGetInsights requestEstimatedAdRecallersField (boolean value) {
      this.requestField("estimated_ad_recallers", value);
      return this;
    }
    public APIRequestGetInsights requestFrequencyField () {
      return this.requestFrequencyField(true);
    }
    public APIRequestGetInsights requestFrequencyField (boolean value) {
      this.requestField("frequency", value);
      return this;
    }
    public APIRequestGetInsights requestImpressionsField () {
      return this.requestImpressionsField(true);
    }
    public APIRequestGetInsights requestImpressionsField (boolean value) {
      this.requestField("impressions", value);
      return this;
    }
    public APIRequestGetInsights requestInlineLinkClickCtrField () {
      return this.requestInlineLinkClickCtrField(true);
    }
    public APIRequestGetInsights requestInlineLinkClickCtrField (boolean value) {
      this.requestField("inline_link_click_ctr", value);
      return this;
    }
    public APIRequestGetInsights requestInlineLinkClicksField () {
      return this.requestInlineLinkClicksField(true);
    }
    public APIRequestGetInsights requestInlineLinkClicksField (boolean value) {
      this.requestField("inline_link_clicks", value);
      return this;
    }
    public APIRequestGetInsights requestInlinePostEngagementField () {
      return this.requestInlinePostEngagementField(true);
    }
    public APIRequestGetInsights requestInlinePostEngagementField (boolean value) {
      this.requestField("inline_post_engagement", value);
      return this;
    }
    public APIRequestGetInsights requestNewsfeedAvgPositionField () {
      return this.requestNewsfeedAvgPositionField(true);
    }
    public APIRequestGetInsights requestNewsfeedAvgPositionField (boolean value) {
      this.requestField("newsfeed_avg_position", value);
      return this;
    }
    public APIRequestGetInsights requestNewsfeedClicksField () {
      return this.requestNewsfeedClicksField(true);
    }
    public APIRequestGetInsights requestNewsfeedClicksField (boolean value) {
      this.requestField("newsfeed_clicks", value);
      return this;
    }
    public APIRequestGetInsights requestNewsfeedImpressionsField () {
      return this.requestNewsfeedImpressionsField(true);
    }
    public APIRequestGetInsights requestNewsfeedImpressionsField (boolean value) {
      this.requestField("newsfeed_impressions", value);
      return this;
    }
    public APIRequestGetInsights requestObjectiveField () {
      return this.requestObjectiveField(true);
    }
    public APIRequestGetInsights requestObjectiveField (boolean value) {
      this.requestField("objective", value);
      return this;
    }
    public APIRequestGetInsights requestPlacePageNameField () {
      return this.requestPlacePageNameField(true);
    }
    public APIRequestGetInsights requestPlacePageNameField (boolean value) {
      this.requestField("place_page_name", value);
      return this;
    }
    public APIRequestGetInsights requestReachField () {
      return this.requestReachField(true);
    }
    public APIRequestGetInsights requestReachField (boolean value) {
      this.requestField("reach", value);
      return this;
    }
    public APIRequestGetInsights requestRelevanceScoreField () {
      return this.requestRelevanceScoreField(true);
    }
    public APIRequestGetInsights requestRelevanceScoreField (boolean value) {
      this.requestField("relevance_score", value);
      return this;
    }
    public APIRequestGetInsights requestSocialClicksField () {
      return this.requestSocialClicksField(true);
    }
    public APIRequestGetInsights requestSocialClicksField (boolean value) {
      this.requestField("social_clicks", value);
      return this;
    }
    public APIRequestGetInsights requestSocialImpressionsField () {
      return this.requestSocialImpressionsField(true);
    }
    public APIRequestGetInsights requestSocialImpressionsField (boolean value) {
      this.requestField("social_impressions", value);
      return this;
    }
    public APIRequestGetInsights requestSocialReachField () {
      return this.requestSocialReachField(true);
    }
    public APIRequestGetInsights requestSocialReachField (boolean value) {
      this.requestField("social_reach", value);
      return this;
    }
    public APIRequestGetInsights requestSocialSpendField () {
      return this.requestSocialSpendField(true);
    }
    public APIRequestGetInsights requestSocialSpendField (boolean value) {
      this.requestField("social_spend", value);
      return this;
    }
    public APIRequestGetInsights requestSpendField () {
      return this.requestSpendField(true);
    }
    public APIRequestGetInsights requestSpendField (boolean value) {
      this.requestField("spend", value);
      return this;
    }
    public APIRequestGetInsights requestTotalActionValueField () {
      return this.requestTotalActionValueField(true);
    }
    public APIRequestGetInsights requestTotalActionValueField (boolean value) {
      this.requestField("total_action_value", value);
      return this;
    }
    public APIRequestGetInsights requestTotalActionsField () {
      return this.requestTotalActionsField(true);
    }
    public APIRequestGetInsights requestTotalActionsField (boolean value) {
      this.requestField("total_actions", value);
      return this;
    }
    public APIRequestGetInsights requestTotalUniqueActionsField () {
      return this.requestTotalUniqueActionsField(true);
    }
    public APIRequestGetInsights requestTotalUniqueActionsField (boolean value) {
      this.requestField("total_unique_actions", value);
      return this;
    }
    public APIRequestGetInsights requestUniqueActionsField () {
      return this.requestUniqueActionsField(true);
    }
    public APIRequestGetInsights requestUniqueActionsField (boolean value) {
      this.requestField("unique_actions", value);
      return this;
    }
    public APIRequestGetInsights requestUniqueClicksField () {
      return this.requestUniqueClicksField(true);
    }
    public APIRequestGetInsights requestUniqueClicksField (boolean value) {
      this.requestField("unique_clicks", value);
      return this;
    }
    public APIRequestGetInsights requestUniqueCtrField () {
      return this.requestUniqueCtrField(true);
    }
    public APIRequestGetInsights requestUniqueCtrField (boolean value) {
      this.requestField("unique_ctr", value);
      return this;
    }
    public APIRequestGetInsights requestUniqueImpressionsField () {
      return this.requestUniqueImpressionsField(true);
    }
    public APIRequestGetInsights requestUniqueImpressionsField (boolean value) {
      this.requestField("unique_impressions", value);
      return this;
    }
    public APIRequestGetInsights requestUniqueInlineLinkClickCtrField () {
      return this.requestUniqueInlineLinkClickCtrField(true);
    }
    public APIRequestGetInsights requestUniqueInlineLinkClickCtrField (boolean value) {
      this.requestField("unique_inline_link_click_ctr", value);
      return this;
    }
    public APIRequestGetInsights requestUniqueInlineLinkClicksField () {
      return this.requestUniqueInlineLinkClicksField(true);
    }
    public APIRequestGetInsights requestUniqueInlineLinkClicksField (boolean value) {
      this.requestField("unique_inline_link_clicks", value);
      return this;
    }
    public APIRequestGetInsights requestUniqueLinkClicksCtrField () {
      return this.requestUniqueLinkClicksCtrField(true);
    }
    public APIRequestGetInsights requestUniqueLinkClicksCtrField (boolean value) {
      this.requestField("unique_link_clicks_ctr", value);
      return this;
    }
    public APIRequestGetInsights requestUniqueSocialClicksField () {
      return this.requestUniqueSocialClicksField(true);
    }
    public APIRequestGetInsights requestUniqueSocialClicksField (boolean value) {
      this.requestField("unique_social_clicks", value);
      return this;
    }
    public APIRequestGetInsights requestUniqueSocialImpressionsField () {
      return this.requestUniqueSocialImpressionsField(true);
    }
    public APIRequestGetInsights requestUniqueSocialImpressionsField (boolean value) {
      this.requestField("unique_social_impressions", value);
      return this;
    }
    public APIRequestGetInsights requestVideo10SecWatchedActionsField () {
      return this.requestVideo10SecWatchedActionsField(true);
    }
    public APIRequestGetInsights requestVideo10SecWatchedActionsField (boolean value) {
      this.requestField("video_10_sec_watched_actions", value);
      return this;
    }
    public APIRequestGetInsights requestVideo15SecWatchedActionsField () {
      return this.requestVideo15SecWatchedActionsField(true);
    }
    public APIRequestGetInsights requestVideo15SecWatchedActionsField (boolean value) {
      this.requestField("video_15_sec_watched_actions", value);
      return this;
    }
    public APIRequestGetInsights requestVideo30SecWatchedActionsField () {
      return this.requestVideo30SecWatchedActionsField(true);
    }
    public APIRequestGetInsights requestVideo30SecWatchedActionsField (boolean value) {
      this.requestField("video_30_sec_watched_actions", value);
      return this;
    }
    public APIRequestGetInsights requestVideoAvgPctWatchedActionsField () {
      return this.requestVideoAvgPctWatchedActionsField(true);
    }
    public APIRequestGetInsights requestVideoAvgPctWatchedActionsField (boolean value) {
      this.requestField("video_avg_pct_watched_actions", value);
      return this;
    }
    public APIRequestGetInsights requestVideoAvgPercentWatchedActionsField () {
      return this.requestVideoAvgPercentWatchedActionsField(true);
    }
    public APIRequestGetInsights requestVideoAvgPercentWatchedActionsField (boolean value) {
      this.requestField("video_avg_percent_watched_actions", value);
      return this;
    }
    public APIRequestGetInsights requestVideoAvgSecWatchedActionsField () {
      return this.requestVideoAvgSecWatchedActionsField(true);
    }
    public APIRequestGetInsights requestVideoAvgSecWatchedActionsField (boolean value) {
      this.requestField("video_avg_sec_watched_actions", value);
      return this;
    }
    public APIRequestGetInsights requestVideoAvgTimeWatchedActionsField () {
      return this.requestVideoAvgTimeWatchedActionsField(true);
    }
    public APIRequestGetInsights requestVideoAvgTimeWatchedActionsField (boolean value) {
      this.requestField("video_avg_time_watched_actions", value);
      return this;
    }
    public APIRequestGetInsights requestVideoCompleteWatchedActionsField () {
      return this.requestVideoCompleteWatchedActionsField(true);
    }
    public APIRequestGetInsights requestVideoCompleteWatchedActionsField (boolean value) {
      this.requestField("video_complete_watched_actions", value);
      return this;
    }
    public APIRequestGetInsights requestVideoP100WatchedActionsField () {
      return this.requestVideoP100WatchedActionsField(true);
    }
    public APIRequestGetInsights requestVideoP100WatchedActionsField (boolean value) {
      this.requestField("video_p100_watched_actions", value);
      return this;
    }
    public APIRequestGetInsights requestVideoP25WatchedActionsField () {
      return this.requestVideoP25WatchedActionsField(true);
    }
    public APIRequestGetInsights requestVideoP25WatchedActionsField (boolean value) {
      this.requestField("video_p25_watched_actions", value);
      return this;
    }
    public APIRequestGetInsights requestVideoP50WatchedActionsField () {
      return this.requestVideoP50WatchedActionsField(true);
    }
    public APIRequestGetInsights requestVideoP50WatchedActionsField (boolean value) {
      this.requestField("video_p50_watched_actions", value);
      return this;
    }
    public APIRequestGetInsights requestVideoP75WatchedActionsField () {
      return this.requestVideoP75WatchedActionsField(true);
    }
    public APIRequestGetInsights requestVideoP75WatchedActionsField (boolean value) {
      this.requestField("video_p75_watched_actions", value);
      return this;
    }
    public APIRequestGetInsights requestVideoP95WatchedActionsField () {
      return this.requestVideoP95WatchedActionsField(true);
    }
    public APIRequestGetInsights requestVideoP95WatchedActionsField (boolean value) {
      this.requestField("video_p95_watched_actions", value);
      return this;
    }
    public APIRequestGetInsights requestWebsiteClicksField () {
      return this.requestWebsiteClicksField(true);
    }
    public APIRequestGetInsights requestWebsiteClicksField (boolean value) {
      this.requestField("website_clicks", value);
      return this;
    }
    public APIRequestGetInsights requestWebsiteCtrField () {
      return this.requestWebsiteCtrField(true);
    }
    public APIRequestGetInsights requestWebsiteCtrField (boolean value) {
      this.requestField("website_ctr", value);
      return this;
    }
  }

  public static class APIRequestGet extends APIRequest<AdReportRun> {

    AdReportRun lastResponse = null;
    @Override
    public AdReportRun getLastResponse() {
      return lastResponse;
    }
    public static final String[] PARAMS = {
    };

    public static final String[] FIELDS = {
      "account_id",
      "async_percent_completion",
      "async_status",
      "date_start",
      "date_stop",
      "emails",
      "friendly_name",
      "id",
      "is_bookmarked",
      "is_running",
      "schedule_id",
      "time_completed",
      "time_ref",
    };

    @Override
    public AdReportRun parseResponse(String response) throws APIException {
      return AdReportRun.parseResponse(response, getContext(), this).head();
    }

    @Override
    public AdReportRun execute() throws APIException {
      return execute(new HashMap<String, Object>());
    }

    @Override
    public AdReportRun execute(Map<String, Object> extraParams) throws APIException {
      lastResponse = parseResponse(executeInternal(extraParams));
      return lastResponse;
    }

    public APIRequestGet(String nodeId, APIContext context) {
      super(context, nodeId, "/", "GET", Arrays.asList(PARAMS));
    }

    @Override
    public APIRequestGet setParam(String param, Object value) {
      setParamInternal(param, value);
      return this;
    }

    @Override
    public APIRequestGet setParams(Map<String, Object> params) {
      setParamsInternal(params);
      return this;
    }


    public APIRequestGet requestAllFields () {
      return this.requestAllFields(true);
    }

    public APIRequestGet requestAllFields (boolean value) {
      for (String field : FIELDS) {
        this.requestField(field, value);
      }
      return this;
    }

    @Override
    public APIRequestGet requestFields (List<String> fields) {
      return this.requestFields(fields, true);
    }

    @Override
    public APIRequestGet requestFields (List<String> fields, boolean value) {
      for (String field : fields) {
        this.requestField(field, value);
      }
      return this;
    }

    @Override
    public APIRequestGet requestField (String field) {
      this.requestField(field, true);
      return this;
    }

    @Override
    public APIRequestGet requestField (String field, boolean value) {
      this.requestFieldInternal(field, value);
      return this;
    }

    public APIRequestGet requestAccountIdField () {
      return this.requestAccountIdField(true);
    }
    public APIRequestGet requestAccountIdField (boolean value) {
      this.requestField("account_id", value);
      return this;
    }
    public APIRequestGet requestAsyncPercentCompletionField () {
      return this.requestAsyncPercentCompletionField(true);
    }
    public APIRequestGet requestAsyncPercentCompletionField (boolean value) {
      this.requestField("async_percent_completion", value);
      return this;
    }
    public APIRequestGet requestAsyncStatusField () {
      return this.requestAsyncStatusField(true);
    }
    public APIRequestGet requestAsyncStatusField (boolean value) {
      this.requestField("async_status", value);
      return this;
    }
    public APIRequestGet requestDateStartField () {
      return this.requestDateStartField(true);
    }
    public APIRequestGet requestDateStartField (boolean value) {
      this.requestField("date_start", value);
      return this;
    }
    public APIRequestGet requestDateStopField () {
      return this.requestDateStopField(true);
    }
    public APIRequestGet requestDateStopField (boolean value) {
      this.requestField("date_stop", value);
      return this;
    }
    public APIRequestGet requestEmailsField () {
      return this.requestEmailsField(true);
    }
    public APIRequestGet requestEmailsField (boolean value) {
      this.requestField("emails", value);
      return this;
    }
    public APIRequestGet requestFriendlyNameField () {
      return this.requestFriendlyNameField(true);
    }
    public APIRequestGet requestFriendlyNameField (boolean value) {
      this.requestField("friendly_name", value);
      return this;
    }
    public APIRequestGet requestIdField () {
      return this.requestIdField(true);
    }
    public APIRequestGet requestIdField (boolean value) {
      this.requestField("id", value);
      return this;
    }
    public APIRequestGet requestIsBookmarkedField () {
      return this.requestIsBookmarkedField(true);
    }
    public APIRequestGet requestIsBookmarkedField (boolean value) {
      this.requestField("is_bookmarked", value);
      return this;
    }
    public APIRequestGet requestIsRunningField () {
      return this.requestIsRunningField(true);
    }
    public APIRequestGet requestIsRunningField (boolean value) {
      this.requestField("is_running", value);
      return this;
    }
    public APIRequestGet requestScheduleIdField () {
      return this.requestScheduleIdField(true);
    }
    public APIRequestGet requestScheduleIdField (boolean value) {
      this.requestField("schedule_id", value);
      return this;
    }
    public APIRequestGet requestTimeCompletedField () {
      return this.requestTimeCompletedField(true);
    }
    public APIRequestGet requestTimeCompletedField (boolean value) {
      this.requestField("time_completed", value);
      return this;
    }
    public APIRequestGet requestTimeRefField () {
      return this.requestTimeRefField(true);
    }
    public APIRequestGet requestTimeRefField (boolean value) {
      this.requestField("time_ref", value);
      return this;
    }
  }

  public static enum EnumActionAttributionWindows {
      @SerializedName("1d_view")
      VALUE_1D_VIEW("1d_view"),
      @SerializedName("7d_view")
      VALUE_7D_VIEW("7d_view"),
      @SerializedName("28d_view")
      VALUE_28D_VIEW("28d_view"),
      @SerializedName("1d_click")
      VALUE_1D_CLICK("1d_click"),
      @SerializedName("7d_click")
      VALUE_7D_CLICK("7d_click"),
      @SerializedName("28d_click")
      VALUE_28D_CLICK("28d_click"),
      @SerializedName("default")
      VALUE_DEFAULT("default"),
      NULL(null);

      private String value;

      private EnumActionAttributionWindows(String value) {
        this.value = value;
      }

      @Override
      public String toString() {
        return value;
      }
  }

  public static enum EnumActionBreakdowns {
      @SerializedName("action_carousel_card_id")
      VALUE_ACTION_CAROUSEL_CARD_ID("action_carousel_card_id"),
      @SerializedName("action_carousel_card_name")
      VALUE_ACTION_CAROUSEL_CARD_NAME("action_carousel_card_name"),
      @SerializedName("action_destination")
      VALUE_ACTION_DESTINATION("action_destination"),
      @SerializedName("action_device")
      VALUE_ACTION_DEVICE("action_device"),
      @SerializedName("action_reaction")
      VALUE_ACTION_REACTION("action_reaction"),
      @SerializedName("action_target_id")
      VALUE_ACTION_TARGET_ID("action_target_id"),
      @SerializedName("action_type")
      VALUE_ACTION_TYPE("action_type"),
      @SerializedName("action_video_sound")
      VALUE_ACTION_VIDEO_SOUND("action_video_sound"),
      @SerializedName("action_video_type")
      VALUE_ACTION_VIDEO_TYPE("action_video_type"),
      NULL(null);

      private String value;

      private EnumActionBreakdowns(String value) {
        this.value = value;
      }

      @Override
      public String toString() {
        return value;
      }
  }

  public static enum EnumActionReportTime {
      @SerializedName("impression")
      VALUE_IMPRESSION("impression"),
      @SerializedName("conversion")
      VALUE_CONVERSION("conversion"),
      NULL(null);

      private String value;

      private EnumActionReportTime(String value) {
        this.value = value;
      }

      @Override
      public String toString() {
        return value;
      }
  }

  public static enum EnumBreakdowns {
      @SerializedName("age")
      VALUE_AGE("age"),
      @SerializedName("country")
      VALUE_COUNTRY("country"),
      @SerializedName("gender")
      VALUE_GENDER("gender"),
      @SerializedName("frequency_value")
      VALUE_FREQUENCY_VALUE("frequency_value"),
      @SerializedName("hourly_stats_aggregated_by_advertiser_time_zone")
      VALUE_HOURLY_STATS_AGGREGATED_BY_ADVERTISER_TIME_ZONE("hourly_stats_aggregated_by_advertiser_time_zone"),
      @SerializedName("hourly_stats_aggregated_by_audience_time_zone")
      VALUE_HOURLY_STATS_AGGREGATED_BY_AUDIENCE_TIME_ZONE("hourly_stats_aggregated_by_audience_time_zone"),
      @SerializedName("impression_device")
      VALUE_IMPRESSION_DEVICE("impression_device"),
      @SerializedName("place_page_id")
      VALUE_PLACE_PAGE_ID("place_page_id"),
      @SerializedName("placement")
      VALUE_PLACEMENT("placement"),
      @SerializedName("device_platform")
      VALUE_DEVICE_PLATFORM("device_platform"),
      @SerializedName("product_id")
      VALUE_PRODUCT_ID("product_id"),
      @SerializedName("region")
      VALUE_REGION("region"),
      NULL(null);

      private String value;

      private EnumBreakdowns(String value) {
        this.value = value;
      }

      @Override
      public String toString() {
        return value;
      }
  }

  public static enum EnumDatePreset {
      @SerializedName("today")
      VALUE_TODAY("today"),
      @SerializedName("yesterday")
      VALUE_YESTERDAY("yesterday"),
      @SerializedName("last_3_days")
      VALUE_LAST_3_DAYS("last_3_days"),
      @SerializedName("this_week")
      VALUE_THIS_WEEK("this_week"),
      @SerializedName("last_week")
      VALUE_LAST_WEEK("last_week"),
      @SerializedName("last_7_days")
      VALUE_LAST_7_DAYS("last_7_days"),
      @SerializedName("last_14_days")
      VALUE_LAST_14_DAYS("last_14_days"),
      @SerializedName("last_28_days")
      VALUE_LAST_28_DAYS("last_28_days"),
      @SerializedName("last_30_days")
      VALUE_LAST_30_DAYS("last_30_days"),
      @SerializedName("last_90_days")
      VALUE_LAST_90_DAYS("last_90_days"),
      @SerializedName("this_month")
      VALUE_THIS_MONTH("this_month"),
      @SerializedName("last_month")
      VALUE_LAST_MONTH("last_month"),
      @SerializedName("this_quarter")
      VALUE_THIS_QUARTER("this_quarter"),
      @SerializedName("last_3_months")
      VALUE_LAST_3_MONTHS("last_3_months"),
      @SerializedName("lifetime")
      VALUE_LIFETIME("lifetime"),
      NULL(null);

      private String value;

      private EnumDatePreset(String value) {
        this.value = value;
      }

      @Override
      public String toString() {
        return value;
      }
  }

  public static enum EnumSummary {
      @SerializedName("id")
      VALUE_ID("id"),
      @SerializedName("account_id")
      VALUE_ACCOUNT_ID("account_id"),
      @SerializedName("async_percent_completion")
      VALUE_ASYNC_PERCENT_COMPLETION("async_percent_completion"),
      @SerializedName("async_status")
      VALUE_ASYNC_STATUS("async_status"),
      @SerializedName("date_start")
      VALUE_DATE_START("date_start"),
      @SerializedName("date_stop")
      VALUE_DATE_STOP("date_stop"),
      @SerializedName("emails")
      VALUE_EMAILS("emails"),
      @SerializedName("friendly_name")
      VALUE_FRIENDLY_NAME("friendly_name"),
      @SerializedName("is_bookmarked")
      VALUE_IS_BOOKMARKED("is_bookmarked"),
      @SerializedName("is_running")
      VALUE_IS_RUNNING("is_running"),
      @SerializedName("schedule_id")
      VALUE_SCHEDULE_ID("schedule_id"),
      @SerializedName("time_completed")
      VALUE_TIME_COMPLETED("time_completed"),
      @SerializedName("time_ref")
      VALUE_TIME_REF("time_ref"),
      NULL(null);

      private String value;

      private EnumSummary(String value) {
        this.value = value;
      }

      @Override
      public String toString() {
        return value;
      }
  }

  public static enum EnumLevel {
      @SerializedName("ad")
      VALUE_AD("ad"),
      @SerializedName("adset")
      VALUE_ADSET("adset"),
      @SerializedName("campaign")
      VALUE_CAMPAIGN("campaign"),
      @SerializedName("account")
      VALUE_ACCOUNT("account"),
      NULL(null);

      private String value;

      private EnumLevel(String value) {
        this.value = value;
      }

      @Override
      public String toString() {
        return value;
      }
  }

  public static enum EnumSummaryActionBreakdowns {
      @SerializedName("action_carousel_card_id")
      VALUE_ACTION_CAROUSEL_CARD_ID("action_carousel_card_id"),
      @SerializedName("action_carousel_card_name")
      VALUE_ACTION_CAROUSEL_CARD_NAME("action_carousel_card_name"),
      @SerializedName("action_destination")
      VALUE_ACTION_DESTINATION("action_destination"),
      @SerializedName("action_device")
      VALUE_ACTION_DEVICE("action_device"),
      @SerializedName("action_reaction")
      VALUE_ACTION_REACTION("action_reaction"),
      @SerializedName("action_target_id")
      VALUE_ACTION_TARGET_ID("action_target_id"),
      @SerializedName("action_type")
      VALUE_ACTION_TYPE("action_type"),
      @SerializedName("action_video_sound")
      VALUE_ACTION_VIDEO_SOUND("action_video_sound"),
      @SerializedName("action_video_type")
      VALUE_ACTION_VIDEO_TYPE("action_video_type"),
      NULL(null);

      private String value;

      private EnumSummaryActionBreakdowns(String value) {
        this.value = value;
      }

      @Override
      public String toString() {
        return value;
      }
  }


  synchronized /*package*/ static Gson getGson() {
    if (gson != null) {
      return gson;
    } else {
      gson = new GsonBuilder()
        .excludeFieldsWithModifiers(Modifier.STATIC)
        .excludeFieldsWithModifiers(Modifier.PROTECTED)
        .disableHtmlEscaping()
        .create();
    }
    return gson;
  }

  public AdReportRun copyFrom(AdReportRun instance) {
    this.mAccountId = instance.mAccountId;
    this.mAsyncPercentCompletion = instance.mAsyncPercentCompletion;
    this.mAsyncStatus = instance.mAsyncStatus;
    this.mDateStart = instance.mDateStart;
    this.mDateStop = instance.mDateStop;
    this.mEmails = instance.mEmails;
    this.mFriendlyName = instance.mFriendlyName;
    this.mId = instance.mId;
    this.mIsBookmarked = instance.mIsBookmarked;
    this.mIsRunning = instance.mIsRunning;
    this.mScheduleId = instance.mScheduleId;
    this.mTimeCompleted = instance.mTimeCompleted;
    this.mTimeRef = instance.mTimeRef;
    this.context = instance.context;
    this.rawValue = instance.rawValue;
    return this;
  }

  public static APIRequest.ResponseParser<AdReportRun> getParser() {
    return new APIRequest.ResponseParser<AdReportRun>() {
      public APINodeList<AdReportRun> parseResponse(String response, APIContext context, APIRequest<AdReportRun> request) throws MalformedResponseException {
        return AdReportRun.parseResponse(response, context, request);
      }
    };
  }
}
