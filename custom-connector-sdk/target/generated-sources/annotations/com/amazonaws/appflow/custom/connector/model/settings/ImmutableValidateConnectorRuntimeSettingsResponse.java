package com.amazonaws.appflow.custom.connector.model.settings;

import com.amazonaws.appflow.custom.connector.model.ErrorDetails;
import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.google.common.base.MoreObjects;
import com.google.common.base.Objects;
import com.google.common.base.Preconditions;
import com.google.common.collect.ImmutableMap;
import com.google.common.collect.Lists;
import com.google.common.primitives.Booleans;
import java.util.List;
import java.util.Map;
import javax.annotation.Nullable;
import javax.annotation.ParametersAreNonnullByDefault;
import javax.annotation.concurrent.Immutable;
import javax.annotation.concurrent.NotThreadSafe;

/**
 * Immutable implementation of {@link ValidateConnectorRuntimeSettingsResponse}.
 * <p>
 * Use the builder to create immutable instances:
 * {@code ImmutableValidateConnectorRuntimeSettingsResponse.builder()}.
 */
@SuppressWarnings("all")
@ParametersAreNonnullByDefault
@Immutable
public final class ImmutableValidateConnectorRuntimeSettingsResponse
    implements ValidateConnectorRuntimeSettingsResponse {
  private final boolean isSuccess;
  private final @Nullable ImmutableMap<String, String> errorsByInputField;
  private final @Nullable ErrorDetails errorDetails;

  private ImmutableValidateConnectorRuntimeSettingsResponse(
      boolean isSuccess,
      @Nullable ImmutableMap<String, String> errorsByInputField,
      @Nullable ErrorDetails errorDetails) {
    this.isSuccess = isSuccess;
    this.errorsByInputField = errorsByInputField;
    this.errorDetails = errorDetails;
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
   * Error message for the invalid connector settings keys. Key will be <code>ConnectorRuntimeSetting.key()</code>
   * provided as input and value will be the error message.
   */
  @JsonProperty("errorsByInputField")
  @Override
  public @Nullable ImmutableMap<String, String> errorsByInputField() {
    return errorsByInputField;
  }

  /**
   * Error details contains ErrorCode and ErrorMessage if the Operation is unsuccessful.
   */
  @JsonProperty("errorDetails")
  @Override
  public @Nullable ErrorDetails errorDetails() {
    return errorDetails;
  }

  /**
   * Copy the current immutable object by setting a value for the {@link ValidateConnectorRuntimeSettingsResponse#isSuccess() isSuccess} attribute.
   * A value equality check is used to prevent copying of the same value by returning {@code this}.
   * @param isSuccess A new value for isSuccess
   * @return A modified copy of the {@code this} object
   */
  public final ImmutableValidateConnectorRuntimeSettingsResponse withIsSuccess(boolean isSuccess) {
    if (this.isSuccess == isSuccess) return this;
    return new ImmutableValidateConnectorRuntimeSettingsResponse(isSuccess, this.errorsByInputField, this.errorDetails);
  }

  /**
   * Copy the current immutable object by replacing the {@link ValidateConnectorRuntimeSettingsResponse#errorsByInputField() errorsByInputField} map with the specified map.
   * Nulls are not permitted as keys or values.
   * A shallow reference equality check is used to prevent copying of the same value by returning {@code this}.
   * @param errorsByInputField The entries to be added to the errorsByInputField map
   * @return A modified copy of {@code this} object
   */
  public final ImmutableValidateConnectorRuntimeSettingsResponse withErrorsByInputField(@Nullable Map<String, ? extends String> errorsByInputField) {
    if (this.errorsByInputField == errorsByInputField) return this;
    @Nullable ImmutableMap<String, String> newValue = errorsByInputField == null ? null : ImmutableMap.copyOf(errorsByInputField);
    return new ImmutableValidateConnectorRuntimeSettingsResponse(this.isSuccess, newValue, this.errorDetails);
  }

  /**
   * Copy the current immutable object by setting a value for the {@link ValidateConnectorRuntimeSettingsResponse#errorDetails() errorDetails} attribute.
   * A shallow reference equality check is used to prevent copying of the same value by returning {@code this}.
   * @param errorDetails A new value for errorDetails (can be {@code null})
   * @return A modified copy of the {@code this} object
   */
  public final ImmutableValidateConnectorRuntimeSettingsResponse withErrorDetails(@Nullable ErrorDetails errorDetails) {
    if (this.errorDetails == errorDetails) return this;
    return new ImmutableValidateConnectorRuntimeSettingsResponse(this.isSuccess, this.errorsByInputField, errorDetails);
  }

  /**
   * This instance is equal to all instances of {@code ImmutableValidateConnectorRuntimeSettingsResponse} that have equal attribute values.
   * @return {@code true} if {@code this} is equal to {@code another} instance
   */
  @Override
  public boolean equals(@Nullable Object another) {
    if (this == another) return true;
    return another instanceof ImmutableValidateConnectorRuntimeSettingsResponse
        && equalTo((ImmutableValidateConnectorRuntimeSettingsResponse) another);
  }

  private boolean equalTo(ImmutableValidateConnectorRuntimeSettingsResponse another) {
    return isSuccess == another.isSuccess
        && Objects.equal(errorsByInputField, another.errorsByInputField)
        && Objects.equal(errorDetails, another.errorDetails);
  }

  /**
   * Computes a hash code from attributes: {@code isSuccess}, {@code errorsByInputField}, {@code errorDetails}.
   * @return hashCode value
   */
  @Override
  public int hashCode() {
    int h = 31;
    h = h * 17 + Booleans.hashCode(isSuccess);
    h = h * 17 + Objects.hashCode(errorsByInputField);
    h = h * 17 + Objects.hashCode(errorDetails);
    return h;
  }

  /**
   * Prints the immutable value {@code ValidateConnectorRuntimeSettingsResponse} with attribute values.
   * @return A string representation of the value
   */
  @Override
  public String toString() {
    return MoreObjects.toStringHelper("ValidateConnectorRuntimeSettingsResponse")
        .omitNullValues()
        .add("isSuccess", isSuccess)
        .add("errorsByInputField", errorsByInputField)
        .add("errorDetails", errorDetails)
        .toString();
  }

  /**
   * Utility type used to correctly read immutable object from JSON representation.
   * @deprecated Do not use this type directly, it exists only for the <em>Jackson</em>-binding infrastructure
   */
  @Deprecated
  @JsonDeserialize
  @JsonAutoDetect(fieldVisibility = JsonAutoDetect.Visibility.NONE)
  static final class Json
      implements ValidateConnectorRuntimeSettingsResponse {
    boolean isSuccess;
    boolean isSuccessIsSet;
    @Nullable Map<String, String> errorsByInputField;
    @Nullable ErrorDetails errorDetails;
    @JsonProperty("isSuccess")
    public void setIsSuccess(boolean isSuccess) {
      this.isSuccess = isSuccess;
      this.isSuccessIsSet = true;
    }
    @JsonProperty("errorsByInputField")
    public void setErrorsByInputField(@Nullable Map<String, String> errorsByInputField) {
      this.errorsByInputField = errorsByInputField;
    }
    @JsonProperty("errorDetails")
    public void setErrorDetails(@Nullable ErrorDetails errorDetails) {
      this.errorDetails = errorDetails;
    }
    @Override
    public boolean isSuccess() { throw new UnsupportedOperationException(); }
    @Override
    public Map<String, String> errorsByInputField() { throw new UnsupportedOperationException(); }
    @Override
    public ErrorDetails errorDetails() { throw new UnsupportedOperationException(); }
  }

  /**
   * @param json A JSON-bindable data structure
   * @return An immutable value type
   * @deprecated Do not use this method directly, it exists only for the <em>Jackson</em>-binding infrastructure
   */
  @Deprecated
  @JsonCreator
  static ImmutableValidateConnectorRuntimeSettingsResponse fromJson(Json json) {
    ImmutableValidateConnectorRuntimeSettingsResponse.Builder builder = ImmutableValidateConnectorRuntimeSettingsResponse.builder();
    if (json.isSuccessIsSet) {
      builder.isSuccess(json.isSuccess);
    }
    if (json.errorsByInputField != null) {
      builder.putAllErrorsByInputField(json.errorsByInputField);
    }
    if (json.errorDetails != null) {
      builder.errorDetails(json.errorDetails);
    }
    return builder.build();
  }

  /**
   * Creates an immutable copy of a {@link ValidateConnectorRuntimeSettingsResponse} value.
   * Uses accessors to get values to initialize the new immutable instance.
   * If an instance is already immutable, it is returned as is.
   * @param instance The instance to copy
   * @return A copied immutable ValidateConnectorRuntimeSettingsResponse instance
   */
  public static ImmutableValidateConnectorRuntimeSettingsResponse copyOf(ValidateConnectorRuntimeSettingsResponse instance) {
    if (instance instanceof ImmutableValidateConnectorRuntimeSettingsResponse) {
      return (ImmutableValidateConnectorRuntimeSettingsResponse) instance;
    }
    return ImmutableValidateConnectorRuntimeSettingsResponse.builder()
        .from(instance)
        .build();
  }

  /**
   * Creates a builder for {@link ImmutableValidateConnectorRuntimeSettingsResponse ImmutableValidateConnectorRuntimeSettingsResponse}.
   * @return A new ImmutableValidateConnectorRuntimeSettingsResponse builder
   */
  public static ImmutableValidateConnectorRuntimeSettingsResponse.Builder builder() {
    return new ImmutableValidateConnectorRuntimeSettingsResponse.Builder();
  }

  /**
   * Builds instances of type {@link ImmutableValidateConnectorRuntimeSettingsResponse ImmutableValidateConnectorRuntimeSettingsResponse}.
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
    private ImmutableMap.Builder<String, String> errorsByInputField = null;
    private @Nullable ErrorDetails errorDetails;

    private Builder() {
    }

    /**
     * Fill a builder with attribute values from the provided {@code ValidateConnectorRuntimeSettingsResponse} instance.
     * Regular attribute values will be replaced with those from the given instance.
     * Absent optional values will not replace present values.
     * Collection elements and entries will be added, not replaced.
     * @param instance The instance from which to copy values
     * @return {@code this} builder for use in a chained invocation
     */
    public final Builder from(ValidateConnectorRuntimeSettingsResponse instance) {
      Preconditions.checkNotNull(instance, "instance");
      isSuccess(instance.isSuccess());
      @Nullable Map<String, String> errorsByInputFieldValue = instance.errorsByInputField();
      if (errorsByInputFieldValue != null) {
        putAllErrorsByInputField(errorsByInputFieldValue);
      }
      @Nullable ErrorDetails errorDetailsValue = instance.errorDetails();
      if (errorDetailsValue != null) {
        errorDetails(errorDetailsValue);
      }
      return this;
    }

    /**
     * Initializes the value for the {@link ValidateConnectorRuntimeSettingsResponse#isSuccess() isSuccess} attribute.
     * @param isSuccess The value for isSuccess 
     * @return {@code this} builder for use in a chained invocation
     */
    public final Builder isSuccess(boolean isSuccess) {
      this.isSuccess = isSuccess;
      initBits &= ~INIT_BIT_IS_SUCCESS;
      return this;
    }

    /**
     * Put one entry to the {@link ValidateConnectorRuntimeSettingsResponse#errorsByInputField() errorsByInputField} map.
     * @param key The key in the errorsByInputField map
     * @param value The associated value in the errorsByInputField map
     * @return {@code this} builder for use in a chained invocation
     */
    public final Builder putErrorsByInputField(String key, String value) {
      if (this.errorsByInputField == null) {
        this.errorsByInputField = ImmutableMap.builder();
      }
      this.errorsByInputField.put(key, value);
      return this;
    }

    /**
     * Put one entry to the {@link ValidateConnectorRuntimeSettingsResponse#errorsByInputField() errorsByInputField} map. Nulls are not permitted
     * @param entry The key and value entry
     * @return {@code this} builder for use in a chained invocation
     */
    public final Builder putErrorsByInputField(Map.Entry<String, ? extends String> entry) {
      if (this.errorsByInputField == null) {
        this.errorsByInputField = ImmutableMap.builder();
      }
      this.errorsByInputField.put(entry);
      return this;
    }

    /**
     * Sets or replaces all mappings from the specified map as entries for the {@link ValidateConnectorRuntimeSettingsResponse#errorsByInputField() errorsByInputField} map. Nulls are not permitted as keys or values, but parameter itself can be null
     * @param errorsByInputField The entries that will be added to the errorsByInputField map
     * @return {@code this} builder for use in a chained invocation
     */
    public final Builder errorsByInputField(@Nullable Map<String, ? extends String> errorsByInputField) {
      if (errorsByInputField == null) {
        this.errorsByInputField = null;
        return this;
      }
      this.errorsByInputField = ImmutableMap.builder();
      return putAllErrorsByInputField(errorsByInputField);
    }

    /**
     * Put all mappings from the specified map as entries to {@link ValidateConnectorRuntimeSettingsResponse#errorsByInputField() errorsByInputField} map. Nulls are not permitted
     * @param errorsByInputField The entries that will be added to the errorsByInputField map
     * @return {@code this} builder for use in a chained invocation
     */
    public final Builder putAllErrorsByInputField(Map<String, ? extends String> errorsByInputField) {
      if (this.errorsByInputField == null) {
        this.errorsByInputField = ImmutableMap.builder();
      }
      this.errorsByInputField.putAll(errorsByInputField);
      return this;
    }

    /**
     * Initializes the value for the {@link ValidateConnectorRuntimeSettingsResponse#errorDetails() errorDetails} attribute.
     * @param errorDetails The value for errorDetails (can be {@code null})
     * @return {@code this} builder for use in a chained invocation
     */
    public final Builder errorDetails(@Nullable ErrorDetails errorDetails) {
      this.errorDetails = errorDetails;
      return this;
    }

    /**
     * Builds a new {@link ImmutableValidateConnectorRuntimeSettingsResponse ImmutableValidateConnectorRuntimeSettingsResponse}.
     * @return An immutable instance of ValidateConnectorRuntimeSettingsResponse
     * @throws java.lang.IllegalStateException if any required attributes are missing
     */
    public ImmutableValidateConnectorRuntimeSettingsResponse build() {
      if (initBits != 0) {
        throw new IllegalStateException(formatRequiredAttributesMessage());
      }
      return new ImmutableValidateConnectorRuntimeSettingsResponse(isSuccess, errorsByInputField == null ? null : errorsByInputField.build(), errorDetails);
    }

    private String formatRequiredAttributesMessage() {
      List<String> attributes = Lists.newArrayList();
      if ((initBits & INIT_BIT_IS_SUCCESS) != 0) attributes.add("isSuccess");
      return "Cannot build ValidateConnectorRuntimeSettingsResponse, some of required attributes are not set " + attributes;
    }
  }
}
