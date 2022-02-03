package com.amazonaws.appflow.custom.connector.model.settings;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import com.fasterxml.jackson.annotation.JsonTypeName;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import javax.annotation.Nullable;
import javax.annotation.ParametersAreNonnullByDefault;
import javax.annotation.concurrent.Immutable;
import javax.annotation.concurrent.NotThreadSafe;

/**
 * Immutable implementation of {@link ValidateConnectorRuntimeSettingsRequest}.
 * <p>
 * Use the builder to create immutable instances:
 * {@code ImmutableValidateConnectorRuntimeSettingsRequest.builder()}.
 */
@SuppressWarnings("all")
@ParametersAreNonnullByDefault
@Immutable
@JsonTypeName("ValidateConnectorRuntimeSettingsRequest")
public final class ImmutableValidateConnectorRuntimeSettingsRequest
    implements ValidateConnectorRuntimeSettingsRequest {
  private final ConnectorRuntimeSettingScope scope;
  private final Map<String, String> connectorRuntimeSettings;

  private ImmutableValidateConnectorRuntimeSettingsRequest(
      ConnectorRuntimeSettingScope scope,
      Map<String, String> connectorRuntimeSettings) {
    this.scope = scope;
    this.connectorRuntimeSettings = connectorRuntimeSettings;
  }

  /**
   * Scope of the connector runtime settings needs to validated.
   */
  @JsonProperty("scope")
  @Override
  public ConnectorRuntimeSettingScope scope() {
    return scope;
  }

  /**
   * Connector settings input. Key will be <code>ConnectorSetting.key()</code> and value will be input provided by
   * user.
   */
  @JsonProperty("connectorRuntimeSettings")
  @Override
  public Map<String, String> connectorRuntimeSettings() {
    return connectorRuntimeSettings;
  }

  /**
   * Copy the current immutable object by setting a value for the {@link ValidateConnectorRuntimeSettingsRequest#scope() scope} attribute.
   * A shallow reference equality check is used to prevent copying of the same value by returning {@code this}.
   * @param scope A new value for scope
   * @return A modified copy of the {@code this} object
   */
  public final ImmutableValidateConnectorRuntimeSettingsRequest withScope(ConnectorRuntimeSettingScope scope) {
    if (this.scope == scope) return this;
    ConnectorRuntimeSettingScope newValue = Objects.requireNonNull(scope, "scope");
    return new ImmutableValidateConnectorRuntimeSettingsRequest(newValue, this.connectorRuntimeSettings);
  }

  /**
   * Copy the current immutable object by replacing the {@link ValidateConnectorRuntimeSettingsRequest#connectorRuntimeSettings() connectorRuntimeSettings} map with the specified map.
   * Nulls are not permitted as keys or values.
   * A shallow reference equality check is used to prevent copying of the same value by returning {@code this}.
   * @param connectorRuntimeSettings The entries to be added to the connectorRuntimeSettings map
   * @return A modified copy of {@code this} object
   */
  public final ImmutableValidateConnectorRuntimeSettingsRequest withConnectorRuntimeSettings(Map<String, ? extends String> connectorRuntimeSettings) {
    if (this.connectorRuntimeSettings == connectorRuntimeSettings) return this;
    Map<String, String> newValue = createUnmodifiableMap(true, false, connectorRuntimeSettings);
    return new ImmutableValidateConnectorRuntimeSettingsRequest(this.scope, newValue);
  }

  /**
   * This instance is equal to all instances of {@code ImmutableValidateConnectorRuntimeSettingsRequest} that have equal attribute values.
   * @return {@code true} if {@code this} is equal to {@code another} instance
   */
  @Override
  public boolean equals(@Nullable Object another) {
    if (this == another) return true;
    return another instanceof ImmutableValidateConnectorRuntimeSettingsRequest
        && equalTo((ImmutableValidateConnectorRuntimeSettingsRequest) another);
  }

  private boolean equalTo(ImmutableValidateConnectorRuntimeSettingsRequest another) {
    return scope.equals(another.scope)
        && connectorRuntimeSettings.equals(another.connectorRuntimeSettings);
  }

  /**
   * Computes a hash code from attributes: {@code scope}, {@code connectorRuntimeSettings}.
   * @return hashCode value
   */
  @Override
  public int hashCode() {
    int h = 31;
    h = h * 17 + scope.hashCode();
    h = h * 17 + connectorRuntimeSettings.hashCode();
    return h;
  }

  /**
   * Prints the immutable value {@code ValidateConnectorRuntimeSettingsRequest} with attribute values.
   * @return A string representation of the value
   */
  @Override
  public String toString() {
    return "ValidateConnectorRuntimeSettingsRequest{"
        + "scope=" + scope
        + ", connectorRuntimeSettings=" + connectorRuntimeSettings
        + "}";
  }

  /**
   * Utility type used to correctly read immutable object from JSON representation.
   * @deprecated Do not use this type directly, it exists only for the <em>Jackson</em>-binding infrastructure
   */
  @Deprecated
  @JsonDeserialize
  @JsonTypeInfo(use=JsonTypeInfo.Id.NONE)
  @JsonAutoDetect(fieldVisibility = JsonAutoDetect.Visibility.NONE)
  static final class Json
      implements ValidateConnectorRuntimeSettingsRequest {
    @Nullable ConnectorRuntimeSettingScope scope;
    @Nullable Map<String, String> connectorRuntimeSettings;
    @JsonProperty("scope")
    public void setScope(ConnectorRuntimeSettingScope scope) {
      this.scope = scope;
    }
    @JsonProperty("connectorRuntimeSettings")
    public void setConnectorRuntimeSettings(Map<String, String> connectorRuntimeSettings) {
      this.connectorRuntimeSettings = connectorRuntimeSettings;
    }
    @Override
    public ConnectorRuntimeSettingScope scope() { throw new UnsupportedOperationException(); }
    @Override
    public Map<String, String> connectorRuntimeSettings() { throw new UnsupportedOperationException(); }
  }

  /**
   * @param json A JSON-bindable data structure
   * @return An immutable value type
   * @deprecated Do not use this method directly, it exists only for the <em>Jackson</em>-binding infrastructure
   */
  @Deprecated
  @JsonCreator
  static ImmutableValidateConnectorRuntimeSettingsRequest fromJson(Json json) {
    ImmutableValidateConnectorRuntimeSettingsRequest.Builder builder = ImmutableValidateConnectorRuntimeSettingsRequest.builder();
    if (json.scope != null) {
      builder.scope(json.scope);
    }
    if (json.connectorRuntimeSettings != null) {
      builder.putAllConnectorRuntimeSettings(json.connectorRuntimeSettings);
    }
    return builder.build();
  }

  /**
   * Creates an immutable copy of a {@link ValidateConnectorRuntimeSettingsRequest} value.
   * Uses accessors to get values to initialize the new immutable instance.
   * If an instance is already immutable, it is returned as is.
   * @param instance The instance to copy
   * @return A copied immutable ValidateConnectorRuntimeSettingsRequest instance
   */
  public static ImmutableValidateConnectorRuntimeSettingsRequest copyOf(ValidateConnectorRuntimeSettingsRequest instance) {
    if (instance instanceof ImmutableValidateConnectorRuntimeSettingsRequest) {
      return (ImmutableValidateConnectorRuntimeSettingsRequest) instance;
    }
    return ImmutableValidateConnectorRuntimeSettingsRequest.builder()
        .from(instance)
        .build();
  }

  /**
   * Creates a builder for {@link ImmutableValidateConnectorRuntimeSettingsRequest ImmutableValidateConnectorRuntimeSettingsRequest}.
   * @return A new ImmutableValidateConnectorRuntimeSettingsRequest builder
   */
  public static ImmutableValidateConnectorRuntimeSettingsRequest.Builder builder() {
    return new ImmutableValidateConnectorRuntimeSettingsRequest.Builder();
  }

  /**
   * Builds instances of type {@link ImmutableValidateConnectorRuntimeSettingsRequest ImmutableValidateConnectorRuntimeSettingsRequest}.
   * Initialize attributes and then invoke the {@link #build()} method to create an
   * immutable instance.
   * <p><em>{@code Builder} is not thread-safe and generally should not be stored in a field or collection,
   * but instead used immediately to create instances.</em>
   */
  @NotThreadSafe
  public static final class Builder {
    private static final long INIT_BIT_SCOPE = 0x1L;
    private long initBits = 0x1L;

    private @Nullable ConnectorRuntimeSettingScope scope;
    private Map<String, String> connectorRuntimeSettings = new LinkedHashMap<String, String>();

    private Builder() {
    }

    /**
     * Fill a builder with attribute values from the provided {@code ValidateConnectorRuntimeSettingsRequest} instance.
     * Regular attribute values will be replaced with those from the given instance.
     * Absent optional values will not replace present values.
     * Collection elements and entries will be added, not replaced.
     * @param instance The instance from which to copy values
     * @return {@code this} builder for use in a chained invocation
     */
    public final Builder from(ValidateConnectorRuntimeSettingsRequest instance) {
      Objects.requireNonNull(instance, "instance");
      scope(instance.scope());
      putAllConnectorRuntimeSettings(instance.connectorRuntimeSettings());
      return this;
    }

    /**
     * Initializes the value for the {@link ValidateConnectorRuntimeSettingsRequest#scope() scope} attribute.
     * @param scope The value for scope 
     * @return {@code this} builder for use in a chained invocation
     */
    public final Builder scope(ConnectorRuntimeSettingScope scope) {
      this.scope = Objects.requireNonNull(scope, "scope");
      initBits &= ~INIT_BIT_SCOPE;
      return this;
    }

    /**
     * Put one entry to the {@link ValidateConnectorRuntimeSettingsRequest#connectorRuntimeSettings() connectorRuntimeSettings} map.
     * @param key The key in the connectorRuntimeSettings map
     * @param value The associated value in the connectorRuntimeSettings map
     * @return {@code this} builder for use in a chained invocation
     */
    public final Builder putConnectorRuntimeSettings(String key, String value) {
      this.connectorRuntimeSettings.put(
          Objects.requireNonNull(key, "connectorRuntimeSettings key"),
          Objects.requireNonNull(value, "connectorRuntimeSettings value"));
      return this;
    }

    /**
     * Put one entry to the {@link ValidateConnectorRuntimeSettingsRequest#connectorRuntimeSettings() connectorRuntimeSettings} map. Nulls are not permitted
     * @param entry The key and value entry
     * @return {@code this} builder for use in a chained invocation
     */
    public final Builder putConnectorRuntimeSettings(Map.Entry<String, ? extends String> entry) {
      String k = entry.getKey();
      String v = entry.getValue();
      this.connectorRuntimeSettings.put(
          Objects.requireNonNull(k, "connectorRuntimeSettings key"),
          Objects.requireNonNull(v, "connectorRuntimeSettings value"));
      return this;
    }

    /**
     * Sets or replaces all mappings from the specified map as entries for the {@link ValidateConnectorRuntimeSettingsRequest#connectorRuntimeSettings() connectorRuntimeSettings} map. Nulls are not permitted
     * @param connectorRuntimeSettings The entries that will be added to the connectorRuntimeSettings map
     * @return {@code this} builder for use in a chained invocation
     */
    public final Builder connectorRuntimeSettings(Map<String, ? extends String> connectorRuntimeSettings) {
      this.connectorRuntimeSettings.clear();
      return putAllConnectorRuntimeSettings(connectorRuntimeSettings);
    }

    /**
     * Put all mappings from the specified map as entries to {@link ValidateConnectorRuntimeSettingsRequest#connectorRuntimeSettings() connectorRuntimeSettings} map. Nulls are not permitted
     * @param connectorRuntimeSettings The entries that will be added to the connectorRuntimeSettings map
     * @return {@code this} builder for use in a chained invocation
     */
    public final Builder putAllConnectorRuntimeSettings(Map<String, ? extends String> connectorRuntimeSettings) {
      for (Map.Entry<String, ? extends String> entry : connectorRuntimeSettings.entrySet()) {
        String k = entry.getKey();
        String v = entry.getValue();
        this.connectorRuntimeSettings.put(
            Objects.requireNonNull(k, "connectorRuntimeSettings key"),
            Objects.requireNonNull(v, "connectorRuntimeSettings value"));
      }
      return this;
    }

    /**
     * Builds a new {@link ImmutableValidateConnectorRuntimeSettingsRequest ImmutableValidateConnectorRuntimeSettingsRequest}.
     * @return An immutable instance of ValidateConnectorRuntimeSettingsRequest
     * @throws java.lang.IllegalStateException if any required attributes are missing
     */
    public ImmutableValidateConnectorRuntimeSettingsRequest build() {
      if (initBits != 0) {
        throw new IllegalStateException(formatRequiredAttributesMessage());
      }
      return new ImmutableValidateConnectorRuntimeSettingsRequest(scope, createUnmodifiableMap(false, false, connectorRuntimeSettings));
    }

    private String formatRequiredAttributesMessage() {
      List<String> attributes = new ArrayList<String>();
      if ((initBits & INIT_BIT_SCOPE) != 0) attributes.add("scope");
      return "Cannot build ValidateConnectorRuntimeSettingsRequest, some of required attributes are not set " + attributes;
    }
  }

  private static <K, V> Map<K, V> createUnmodifiableMap(boolean checkNulls, boolean skipNulls, Map<? extends K, ? extends V> map) {
    switch (map.size()) {
    case 0: return Collections.emptyMap();
    case 1: {
      Map.Entry<? extends K, ? extends V> e = map.entrySet().iterator().next();
      K k = e.getKey();
      V v = e.getValue();
      if (checkNulls) {
        Objects.requireNonNull(k, "key");
        Objects.requireNonNull(v, "value");
      }
      if (skipNulls && (k == null || v == null)) {
        return Collections.emptyMap();
      }
      return Collections.singletonMap(k, v);
    }
    default: {
      Map<K, V> linkedMap = new LinkedHashMap<K, V>(map.size());
      if (skipNulls || checkNulls) {
        for (Map.Entry<? extends K, ? extends V> e : map.entrySet()) {
          K k = e.getKey();
          V v = e.getValue();
          if (skipNulls) {
            if (k == null || v == null) continue;
          } else if (checkNulls) {
            Objects.requireNonNull(k, "key");
            Objects.requireNonNull(v, "value");
          }
          linkedMap.put(k, v);
        }
      } else {
        linkedMap.putAll(map);
      }
      return Collections.unmodifiableMap(linkedMap);
    }
    }
  }
}
