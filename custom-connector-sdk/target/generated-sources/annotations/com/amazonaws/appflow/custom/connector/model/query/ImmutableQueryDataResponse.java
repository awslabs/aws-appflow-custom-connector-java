package com.amazonaws.appflow.custom.connector.model.query;

import com.amazonaws.appflow.custom.connector.model.ErrorDetails;
import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.google.common.base.MoreObjects;
import com.google.common.base.Objects;
import com.google.common.base.Preconditions;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.Lists;
import com.google.common.primitives.Booleans;
import java.util.List;
import javax.annotation.Nullable;
import javax.annotation.ParametersAreNonnullByDefault;
import javax.annotation.concurrent.Immutable;
import javax.annotation.concurrent.NotThreadSafe;

/**
 * Immutable implementation of {@link QueryDataResponse}.
 * <p>
 * Use the builder to create immutable instances:
 * {@code ImmutableQueryDataResponse.builder()}.
 */
@SuppressWarnings("all")
@ParametersAreNonnullByDefault
@Immutable
public final class ImmutableQueryDataResponse
    implements QueryDataResponse {
  private final boolean isSuccess;
  private final @Nullable ErrorDetails errorDetails;
  private final @Nullable String nextToken;
  private final @Nullable ImmutableList<String> records;

  private ImmutableQueryDataResponse(
      boolean isSuccess,
      @Nullable ErrorDetails errorDetails,
      @Nullable String nextToken,
      @Nullable ImmutableList<String> records) {
    this.isSuccess = isSuccess;
    this.errorDetails = errorDetails;
    this.nextToken = nextToken;
    this.records = records;
  }

  /**
   * Specifies if the operation is successful or not.
   */
  @JsonProperty("isSuccess")
  @Override
  public boolean isSuccess() {
    return isSuccess;
  }

  /**
   * Error details if the Operation is unsuccessful.
   */
  @JsonProperty("errorDetails")
  @Override
  public @Nullable ErrorDetails errorDetails() {
    return errorDetails;
  }

  /**
   * The pagination token for the next page of data.
   */
  @JsonProperty("nextToken")
  @Override
  public @Nullable String nextToken() {
    return nextToken;
  }

  /**
   * List of json serialized string of the entity record as per the entity metadata.
   */
  @JsonProperty("records")
  @Override
  public @Nullable ImmutableList<String> records() {
    return records;
  }

  /**
   * Copy the current immutable object by setting a value for the {@link QueryDataResponse#isSuccess() isSuccess} attribute.
   * A value equality check is used to prevent copying of the same value by returning {@code this}.
   * @param isSuccess A new value for isSuccess
   * @return A modified copy of the {@code this} object
   */
  public final ImmutableQueryDataResponse withIsSuccess(boolean isSuccess) {
    if (this.isSuccess == isSuccess) return this;
    return new ImmutableQueryDataResponse(isSuccess, this.errorDetails, this.nextToken, this.records);
  }

  /**
   * Copy the current immutable object by setting a value for the {@link QueryDataResponse#errorDetails() errorDetails} attribute.
   * A shallow reference equality check is used to prevent copying of the same value by returning {@code this}.
   * @param errorDetails A new value for errorDetails (can be {@code null})
   * @return A modified copy of the {@code this} object
   */
  public final ImmutableQueryDataResponse withErrorDetails(@Nullable ErrorDetails errorDetails) {
    if (this.errorDetails == errorDetails) return this;
    return new ImmutableQueryDataResponse(this.isSuccess, errorDetails, this.nextToken, this.records);
  }

  /**
   * Copy the current immutable object by setting a value for the {@link QueryDataResponse#nextToken() nextToken} attribute.
   * An equals check used to prevent copying of the same value by returning {@code this}.
   * @param nextToken A new value for nextToken (can be {@code null})
   * @return A modified copy of the {@code this} object
   */
  public final ImmutableQueryDataResponse withNextToken(@Nullable String nextToken) {
    if (Objects.equal(this.nextToken, nextToken)) return this;
    return new ImmutableQueryDataResponse(this.isSuccess, this.errorDetails, nextToken, this.records);
  }

  /**
   * Copy the current immutable object with elements that replace the content of {@link QueryDataResponse#records() records}.
   * @param elements The elements to set
   * @return A modified copy of {@code this} object
   */
  public final ImmutableQueryDataResponse withRecords(@Nullable String... elements) {
    if (elements == null) {
      return new ImmutableQueryDataResponse(this.isSuccess, this.errorDetails, this.nextToken, null);
    }
    @Nullable ImmutableList<String> newValue = elements == null ? null : ImmutableList.copyOf(elements);
    return new ImmutableQueryDataResponse(this.isSuccess, this.errorDetails, this.nextToken, newValue);
  }

  /**
   * Copy the current immutable object with elements that replace the content of {@link QueryDataResponse#records() records}.
   * A shallow reference equality check is used to prevent copying of the same value by returning {@code this}.
   * @param elements An iterable of records elements to set
   * @return A modified copy of {@code this} object
   */
  public final ImmutableQueryDataResponse withRecords(@Nullable Iterable<String> elements) {
    if (this.records == elements) return this;
    @Nullable ImmutableList<String> newValue = elements == null ? null : ImmutableList.copyOf(elements);
    return new ImmutableQueryDataResponse(this.isSuccess, this.errorDetails, this.nextToken, newValue);
  }

  /**
   * This instance is equal to all instances of {@code ImmutableQueryDataResponse} that have equal attribute values.
   * @return {@code true} if {@code this} is equal to {@code another} instance
   */
  @Override
  public boolean equals(@Nullable Object another) {
    if (this == another) return true;
    return another instanceof ImmutableQueryDataResponse
        && equalTo((ImmutableQueryDataResponse) another);
  }

  private boolean equalTo(ImmutableQueryDataResponse another) {
    return isSuccess == another.isSuccess
        && Objects.equal(errorDetails, another.errorDetails)
        && Objects.equal(nextToken, another.nextToken)
        && Objects.equal(records, another.records);
  }

  /**
   * Computes a hash code from attributes: {@code isSuccess}, {@code errorDetails}, {@code nextToken}, {@code records}.
   * @return hashCode value
   */
  @Override
  public int hashCode() {
    int h = 31;
    h = h * 17 + Booleans.hashCode(isSuccess);
    h = h * 17 + Objects.hashCode(errorDetails);
    h = h * 17 + Objects.hashCode(nextToken);
    h = h * 17 + Objects.hashCode(records);
    return h;
  }

  /**
   * Prints the immutable value {@code QueryDataResponse} with attribute values.
   * @return A string representation of the value
   */
  @Override
  public String toString() {
    return MoreObjects.toStringHelper("QueryDataResponse")
        .omitNullValues()
        .add("isSuccess", isSuccess)
        .add("errorDetails", errorDetails)
        .add("nextToken", nextToken)
        .add("records", records)
        .toString();
  }

  /**
   * Utility type used to correctly read immutable object from JSON representation.
   * @deprecated Do not use this type directly, it exists only for the <em>Jackson</em>-binding infrastructure
   */
  @Deprecated
  @JsonDeserialize
  @JsonAutoDetect(fieldVisibility = JsonAutoDetect.Visibility.NONE)
  static final class Json implements QueryDataResponse {
    boolean isSuccess;
    boolean isSuccessIsSet;
    @Nullable ErrorDetails errorDetails;
    @Nullable String nextToken;
    List<String> records = null;
    @JsonProperty("isSuccess")
    public void setIsSuccess(boolean isSuccess) {
      this.isSuccess = isSuccess;
      this.isSuccessIsSet = true;
    }
    @JsonProperty("errorDetails")
    public void setErrorDetails(@Nullable ErrorDetails errorDetails) {
      this.errorDetails = errorDetails;
    }
    @JsonProperty("nextToken")
    public void setNextToken(@Nullable String nextToken) {
      this.nextToken = nextToken;
    }
    @JsonProperty("records")
    public void setRecords(@Nullable List<String> records) {
      this.records = records;
    }
    @Override
    public boolean isSuccess() { throw new UnsupportedOperationException(); }
    @Override
    public ErrorDetails errorDetails() { throw new UnsupportedOperationException(); }
    @Override
    public String nextToken() { throw new UnsupportedOperationException(); }
    @Override
    public List<String> records() { throw new UnsupportedOperationException(); }
  }

  /**
   * @param json A JSON-bindable data structure
   * @return An immutable value type
   * @deprecated Do not use this method directly, it exists only for the <em>Jackson</em>-binding infrastructure
   */
  @Deprecated
  @JsonCreator
  static ImmutableQueryDataResponse fromJson(Json json) {
    ImmutableQueryDataResponse.Builder builder = ImmutableQueryDataResponse.builder();
    if (json.isSuccessIsSet) {
      builder.isSuccess(json.isSuccess);
    }
    if (json.errorDetails != null) {
      builder.errorDetails(json.errorDetails);
    }
    if (json.nextToken != null) {
      builder.nextToken(json.nextToken);
    }
    if (json.records != null) {
      builder.addAllRecords(json.records);
    }
    return builder.build();
  }

  /**
   * Creates an immutable copy of a {@link QueryDataResponse} value.
   * Uses accessors to get values to initialize the new immutable instance.
   * If an instance is already immutable, it is returned as is.
   * @param instance The instance to copy
   * @return A copied immutable QueryDataResponse instance
   */
  public static ImmutableQueryDataResponse copyOf(QueryDataResponse instance) {
    if (instance instanceof ImmutableQueryDataResponse) {
      return (ImmutableQueryDataResponse) instance;
    }
    return ImmutableQueryDataResponse.builder()
        .from(instance)
        .build();
  }

  /**
   * Creates a builder for {@link ImmutableQueryDataResponse ImmutableQueryDataResponse}.
   * @return A new ImmutableQueryDataResponse builder
   */
  public static ImmutableQueryDataResponse.Builder builder() {
    return new ImmutableQueryDataResponse.Builder();
  }

  /**
   * Builds instances of type {@link ImmutableQueryDataResponse ImmutableQueryDataResponse}.
   * Initialize attributes and then invoke the {@link #build()} method to create an
   * immutable instance.
   * <p><em>{@code Builder} is not thread-safe and generally should not be stored in a field or collection,
   * but instead used immediately to create instances.</em>
   */
  @NotThreadSafe
  public static final class Builder {
    private static final long INIT_BIT_IS_SUCCESS = 0x1L;
    private long initBits = 0x1L;

    private boolean isSuccess;
    private @Nullable ErrorDetails errorDetails;
    private @Nullable String nextToken;
    private ImmutableList.Builder<String> records = null;

    private Builder() {
    }

    /**
     * Fill a builder with attribute values from the provided {@code QueryDataResponse} instance.
     * Regular attribute values will be replaced with those from the given instance.
     * Absent optional values will not replace present values.
     * Collection elements and entries will be added, not replaced.
     * @param instance The instance from which to copy values
     * @return {@code this} builder for use in a chained invocation
     */
    public final Builder from(QueryDataResponse instance) {
      Preconditions.checkNotNull(instance, "instance");
      isSuccess(instance.isSuccess());
      @Nullable ErrorDetails errorDetailsValue = instance.errorDetails();
      if (errorDetailsValue != null) {
        errorDetails(errorDetailsValue);
      }
      @Nullable String nextTokenValue = instance.nextToken();
      if (nextTokenValue != null) {
        nextToken(nextTokenValue);
      }
      @Nullable List<String> recordsValue = instance.records();
      if (recordsValue != null) {
        addAllRecords(recordsValue);
      }
      return this;
    }

    /**
     * Initializes the value for the {@link QueryDataResponse#isSuccess() isSuccess} attribute.
     * @param isSuccess The value for isSuccess 
     * @return {@code this} builder for use in a chained invocation
     */
    public final Builder isSuccess(boolean isSuccess) {
      this.isSuccess = isSuccess;
      initBits &= ~INIT_BIT_IS_SUCCESS;
      return this;
    }

    /**
     * Initializes the value for the {@link QueryDataResponse#errorDetails() errorDetails} attribute.
     * @param errorDetails The value for errorDetails (can be {@code null})
     * @return {@code this} builder for use in a chained invocation
     */
    public final Builder errorDetails(@Nullable ErrorDetails errorDetails) {
      this.errorDetails = errorDetails;
      return this;
    }

    /**
     * Initializes the value for the {@link QueryDataResponse#nextToken() nextToken} attribute.
     * @param nextToken The value for nextToken (can be {@code null})
     * @return {@code this} builder for use in a chained invocation
     */
    public final Builder nextToken(@Nullable String nextToken) {
      this.nextToken = nextToken;
      return this;
    }

    /**
     * Adds one element to {@link QueryDataResponse#records() records} list.
     * @param element A records element
     * @return {@code this} builder for use in a chained invocation
     */
    public final Builder addRecords(String element) {
      if (this.records == null) {
        this.records = ImmutableList.builder();
      }
      this.records.add(element);
      return this;
    }

    /**
     * Adds elements to {@link QueryDataResponse#records() records} list.
     * @param elements An array of records elements
     * @return {@code this} builder for use in a chained invocation
     */
    public final Builder addRecords(String... elements) {
      if (this.records == null) {
        this.records = ImmutableList.builder();
      }
      this.records.add(elements);
      return this;
    }

    /**
     * Sets or replaces all elements for {@link QueryDataResponse#records() records} list.
     * @param elements An iterable of records elements
     * @return {@code this} builder for use in a chained invocation
     */
    public final Builder records(@Nullable Iterable<String> elements) {
      if (elements == null) {
        this.records = null;
        return this;
      }
      this.records = ImmutableList.builder();
      return addAllRecords(elements);
    }

    /**
     * Adds elements to {@link QueryDataResponse#records() records} list.
     * @param elements An iterable of records elements
     * @return {@code this} builder for use in a chained invocation
     */
    public final Builder addAllRecords(Iterable<String> elements) {
      Preconditions.checkNotNull(elements, "records element");
      if (this.records == null) {
        this.records = ImmutableList.builder();
      }
      this.records.addAll(elements);
      return this;
    }

    /**
     * Builds a new {@link ImmutableQueryDataResponse ImmutableQueryDataResponse}.
     * @return An immutable instance of QueryDataResponse
     * @throws java.lang.IllegalStateException if any required attributes are missing
     */
    public ImmutableQueryDataResponse build() {
      if (initBits != 0) {
        throw new IllegalStateException(formatRequiredAttributesMessage());
      }
      return new ImmutableQueryDataResponse(isSuccess, errorDetails, nextToken, records == null ? null : records.build());
    }

    private String formatRequiredAttributesMessage() {
      List<String> attributes = Lists.newArrayList();
      if ((initBits & INIT_BIT_IS_SUCCESS) != 0) attributes.add("isSuccess");
      return "Cannot build QueryDataResponse, some of required attributes are not set " + attributes;
    }
  }
}
