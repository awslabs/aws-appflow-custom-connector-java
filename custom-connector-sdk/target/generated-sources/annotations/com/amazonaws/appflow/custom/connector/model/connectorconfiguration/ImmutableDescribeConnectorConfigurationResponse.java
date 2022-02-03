package com.amazonaws.appflow.custom.connector.model.connectorconfiguration;

import com.amazonaws.appflow.custom.connector.model.ErrorDetails;
import com.amazonaws.appflow.custom.connector.model.connectorconfiguration.auth.AuthenticationConfig;
import com.amazonaws.appflow.custom.connector.model.settings.ConnectorRuntimeSetting;
import com.amazonaws.appflow.custom.connector.model.write.WriteOperationType;
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
import java.util.ArrayList;
import java.util.List;
import javax.annotation.Nullable;
import javax.annotation.ParametersAreNonnullByDefault;
import javax.annotation.concurrent.Immutable;
import javax.annotation.concurrent.NotThreadSafe;

/**
 * Immutable implementation of {@link DescribeConnectorConfigurationResponse}.
 * <p>
 * Use the builder to create immutable instances:
 * {@code ImmutableDescribeConnectorConfigurationResponse.builder()}.
 */
@SuppressWarnings("all")
@ParametersAreNonnullByDefault
@Immutable
public final class ImmutableDescribeConnectorConfigurationResponse
    implements DescribeConnectorConfigurationResponse {
  private final String connectorOwner;
  private final String connectorName;
  private final String connectorVersion;
  private final ImmutableList<ConnectorModes> connectorModes;
  private final @Nullable AuthenticationConfig authenticationConfig;
  private final @Nullable ImmutableList<ConnectorRuntimeSetting> connectorRuntimeSetting;
  private final ImmutableList<String> supportedApiVersions;
  private final ImmutableList<ConnectorOperator> operatorsSupported;
  private final ImmutableList<TriggerType> supportedTriggerTypes;
  private final ImmutableList<TriggerFrequency> triggerFrequenciesSupported;
  private final ImmutableList<WriteOperationType> supportedWriteOperations;
  private final @Nullable String logoURL;
  private final boolean isSuccess;
  private final @Nullable ErrorDetails errorDetails;

  private ImmutableDescribeConnectorConfigurationResponse(ImmutableDescribeConnectorConfigurationResponse.Builder builder) {
    this.connectorOwner = builder.connectorOwner;
    this.connectorName = builder.connectorName;
    this.connectorVersion = builder.connectorVersion;
    this.connectorModes = builder.connectorModes.build();
    this.authenticationConfig = builder.authenticationConfig;
    this.connectorRuntimeSetting = builder.connectorRuntimeSetting == null ? null : builder.connectorRuntimeSetting.build();
    this.supportedApiVersions = builder.supportedApiVersions.build();
    this.logoURL = builder.logoURL;
    this.isSuccess = builder.isSuccess;
    this.errorDetails = builder.errorDetails;
    if (builder.operatorsSupportedIsSet()) {
      initShim.operatorsSupported(builder.operatorsSupported.build());
    }
    if (builder.supportedTriggerTypesIsSet()) {
      initShim.supportedTriggerTypes(builder.supportedTriggerTypes.build());
    }
    if (builder.triggerFrequenciesSupportedIsSet()) {
      initShim.triggerFrequenciesSupported(builder.triggerFrequenciesSupported.build());
    }
    if (builder.supportedWriteOperationsIsSet()) {
      initShim.supportedWriteOperations(builder.supportedWriteOperations.build());
    }
    this.operatorsSupported = initShim.operatorsSupported();
    this.supportedTriggerTypes = initShim.supportedTriggerTypes();
    this.triggerFrequenciesSupported = initShim.triggerFrequenciesSupported();
    this.supportedWriteOperations = initShim.supportedWriteOperations();
    this.initShim = null;
  }

  private ImmutableDescribeConnectorConfigurationResponse(
      String connectorOwner,
      String connectorName,
      String connectorVersion,
      ImmutableList<ConnectorModes> connectorModes,
      @Nullable AuthenticationConfig authenticationConfig,
      @Nullable ImmutableList<ConnectorRuntimeSetting> connectorRuntimeSetting,
      ImmutableList<String> supportedApiVersions,
      ImmutableList<ConnectorOperator> operatorsSupported,
      ImmutableList<TriggerType> supportedTriggerTypes,
      ImmutableList<TriggerFrequency> triggerFrequenciesSupported,
      ImmutableList<WriteOperationType> supportedWriteOperations,
      @Nullable String logoURL,
      boolean isSuccess,
      @Nullable ErrorDetails errorDetails) {
    this.connectorOwner = connectorOwner;
    this.connectorName = connectorName;
    this.connectorVersion = connectorVersion;
    this.connectorModes = connectorModes;
    this.authenticationConfig = authenticationConfig;
    this.connectorRuntimeSetting = connectorRuntimeSetting;
    this.supportedApiVersions = supportedApiVersions;
    this.operatorsSupported = operatorsSupported;
    this.supportedTriggerTypes = supportedTriggerTypes;
    this.triggerFrequenciesSupported = triggerFrequenciesSupported;
    this.supportedWriteOperations = supportedWriteOperations;
    this.logoURL = logoURL;
    this.isSuccess = isSuccess;
    this.errorDetails = errorDetails;
    this.initShim = null;
  }

  private static final int STAGE_INITIALIZING = -1;
  private static final int STAGE_UNINITIALIZED = 0;
  private static final int STAGE_INITIALIZED = 1;
  private transient volatile InitShim initShim = new InitShim();

  private final class InitShim {
    private ImmutableList<ConnectorOperator> operatorsSupported;
    private int operatorsSupportedStage;

    ImmutableList<ConnectorOperator> operatorsSupported() {
      if (operatorsSupportedStage == STAGE_INITIALIZING) throw new IllegalStateException(formatInitCycleMessage());
      if (operatorsSupportedStage == STAGE_UNINITIALIZED) {
        operatorsSupportedStage = STAGE_INITIALIZING;
        this.operatorsSupported = ImmutableList.copyOf(operatorsSupportedInitialize());
        operatorsSupportedStage = STAGE_INITIALIZED;
      }
      return this.operatorsSupported;
    }

    void operatorsSupported(ImmutableList<ConnectorOperator> operatorsSupported) {
      this.operatorsSupported = operatorsSupported;
      operatorsSupportedStage = STAGE_INITIALIZED;
    }
    private ImmutableList<TriggerType> supportedTriggerTypes;
    private int supportedTriggerTypesStage;

    ImmutableList<TriggerType> supportedTriggerTypes() {
      if (supportedTriggerTypesStage == STAGE_INITIALIZING) throw new IllegalStateException(formatInitCycleMessage());
      if (supportedTriggerTypesStage == STAGE_UNINITIALIZED) {
        supportedTriggerTypesStage = STAGE_INITIALIZING;
        this.supportedTriggerTypes = ImmutableList.copyOf(supportedTriggerTypesInitialize());
        supportedTriggerTypesStage = STAGE_INITIALIZED;
      }
      return this.supportedTriggerTypes;
    }

    void supportedTriggerTypes(ImmutableList<TriggerType> supportedTriggerTypes) {
      this.supportedTriggerTypes = supportedTriggerTypes;
      supportedTriggerTypesStage = STAGE_INITIALIZED;
    }
    private ImmutableList<TriggerFrequency> triggerFrequenciesSupported;
    private int triggerFrequenciesSupportedStage;

    ImmutableList<TriggerFrequency> triggerFrequenciesSupported() {
      if (triggerFrequenciesSupportedStage == STAGE_INITIALIZING) throw new IllegalStateException(formatInitCycleMessage());
      if (triggerFrequenciesSupportedStage == STAGE_UNINITIALIZED) {
        triggerFrequenciesSupportedStage = STAGE_INITIALIZING;
        this.triggerFrequenciesSupported = ImmutableList.copyOf(triggerFrequenciesSupportedInitialize());
        triggerFrequenciesSupportedStage = STAGE_INITIALIZED;
      }
      return this.triggerFrequenciesSupported;
    }

    void triggerFrequenciesSupported(ImmutableList<TriggerFrequency> triggerFrequenciesSupported) {
      this.triggerFrequenciesSupported = triggerFrequenciesSupported;
      triggerFrequenciesSupportedStage = STAGE_INITIALIZED;
    }
    private ImmutableList<WriteOperationType> supportedWriteOperations;
    private int supportedWriteOperationsStage;

    ImmutableList<WriteOperationType> supportedWriteOperations() {
      if (supportedWriteOperationsStage == STAGE_INITIALIZING) throw new IllegalStateException(formatInitCycleMessage());
      if (supportedWriteOperationsStage == STAGE_UNINITIALIZED) {
        supportedWriteOperationsStage = STAGE_INITIALIZING;
        this.supportedWriteOperations = ImmutableList.copyOf(supportedWriteOperationsInitialize());
        supportedWriteOperationsStage = STAGE_INITIALIZED;
      }
      return this.supportedWriteOperations;
    }

    void supportedWriteOperations(ImmutableList<WriteOperationType> supportedWriteOperations) {
      this.supportedWriteOperations = supportedWriteOperations;
      supportedWriteOperationsStage = STAGE_INITIALIZED;
    }

    private String formatInitCycleMessage() {
      ArrayList<String> attributes = Lists.newArrayList();
      if (operatorsSupportedStage == STAGE_INITIALIZING) attributes.add("operatorsSupported");
      if (supportedTriggerTypesStage == STAGE_INITIALIZING) attributes.add("supportedTriggerTypes");
      if (triggerFrequenciesSupportedStage == STAGE_INITIALIZING) attributes.add("triggerFrequenciesSupported");
      if (supportedWriteOperationsStage == STAGE_INITIALIZING) attributes.add("supportedWriteOperations");
      return "Cannot build DescribeConnectorConfigurationResponse, attribute initializers form cycle" + attributes;
    }
  }

  private List<ConnectorOperator> operatorsSupportedInitialize() {
    return DescribeConnectorConfigurationResponse.super.operatorsSupported();
  }

  private List<TriggerType> supportedTriggerTypesInitialize() {
    return DescribeConnectorConfigurationResponse.super.supportedTriggerTypes();
  }

  private List<TriggerFrequency> triggerFrequenciesSupportedInitialize() {
    return DescribeConnectorConfigurationResponse.super.triggerFrequenciesSupported();
  }

  private List<WriteOperationType> supportedWriteOperationsInitialize() {
    return DescribeConnectorConfigurationResponse.super.supportedWriteOperations();
  }

  /**
   * Name of the connector owner.
   */
  @JsonProperty("connectorOwner")
  @Override
  public String connectorOwner() {
    return connectorOwner;
  }

  /**
   * Name of the connector.
   */
  @JsonProperty("connectorName")
  @Override
  public String connectorName() {
    return connectorName;
  }

  /**
   * Version of the connector.
   */
  @JsonProperty("connectorVersion")
  @Override
  public String connectorVersion() {
    return connectorVersion;
  }

  /**
   * List of <code>ConnectorMode</code> supported by the connector.
   */
  @JsonProperty("connectorModes")
  @Override
  public ImmutableList<ConnectorModes> connectorModes() {
    return connectorModes;
  }

  /**
   * <code>AuthenticationConfig</code> supported by the connector. Can be null if connector doesn't need any
   * credentials from customer.
   */
  @JsonProperty("authenticationConfig")
  @Override
  public @Nullable AuthenticationConfig authenticationConfig() {
    return authenticationConfig;
  }

  /**
   * Custom connector runtime settings for which connector requires input from the end user.
   */
  @JsonProperty("connectorRuntimeSetting")
  @Override
  public @Nullable ImmutableList<ConnectorRuntimeSetting> connectorRuntimeSetting() {
    return connectorRuntimeSetting;
  }

  /**
   * List of API versions supported by connector for the underlying application. For example, if the underlying
   * application is Salesforce, then example could be List of {v46.0, v47.0, v48.9}.
   */
  @JsonProperty("supportedApiVersions")
  @Override
  public ImmutableList<String> supportedApiVersions() {
    return supportedApiVersions;
  }

  /**
   * Operators supported by the connector. Default: all the operators
   */
  @JsonProperty("operatorsSupported")
  @Override
  public ImmutableList<ConnectorOperator> operatorsSupported() {
    InitShim shim = this.initShim;
    return shim != null
        ? shim.operatorsSupported()
        : this.operatorsSupported;
  }

  /**
   * Trigger types supported by connector. Default is OnDemand and Scheduled.
   */
  @JsonProperty("supportedTriggerTypes")
  @Override
  public ImmutableList<TriggerType> supportedTriggerTypes() {
    InitShim shim = this.initShim;
    return shim != null
        ? shim.supportedTriggerTypes()
        : this.supportedTriggerTypes;
  }

  /**
   * Trigger frequencies supported by Connector. Default: all trigger frequencies
   */
  @JsonProperty("triggerFrequenciesSupported")
  @Override
  public ImmutableList<TriggerFrequency> triggerFrequenciesSupported() {
    InitShim shim = this.initShim;
    return shim != null
        ? shim.triggerFrequenciesSupported()
        : this.triggerFrequenciesSupported;
  }

  /**
   * Write Operations supported by Connector. Only applicable if the connector support DESTINATION mode. Default is
   * all the Write Operation types supported.
   */
  @JsonProperty("supportedWriteOperations")
  @Override
  public ImmutableList<WriteOperationType> supportedWriteOperations() {
    InitShim shim = this.initShim;
    return shim != null
        ? shim.supportedWriteOperations()
        : this.supportedWriteOperations;
  }

  /**
   * Logo URL for display purposes for connector icon.
   */
  @JsonProperty("logoURL")
  @Override
  public @Nullable String logoURL() {
    return logoURL;
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
   * Copy the current immutable object by setting a value for the {@link DescribeConnectorConfigurationResponse#connectorOwner() connectorOwner} attribute.
   * An equals check used to prevent copying of the same value by returning {@code this}.
   * @param connectorOwner A new value for connectorOwner
   * @return A modified copy of the {@code this} object
   */
  public final ImmutableDescribeConnectorConfigurationResponse withConnectorOwner(String connectorOwner) {
    if (this.connectorOwner.equals(connectorOwner)) return this;
    String newValue = Preconditions.checkNotNull(connectorOwner, "connectorOwner");
    return new ImmutableDescribeConnectorConfigurationResponse(
        newValue,
        this.connectorName,
        this.connectorVersion,
        this.connectorModes,
        this.authenticationConfig,
        this.connectorRuntimeSetting,
        this.supportedApiVersions,
        this.operatorsSupported,
        this.supportedTriggerTypes,
        this.triggerFrequenciesSupported,
        this.supportedWriteOperations,
        this.logoURL,
        this.isSuccess,
        this.errorDetails);
  }

  /**
   * Copy the current immutable object by setting a value for the {@link DescribeConnectorConfigurationResponse#connectorName() connectorName} attribute.
   * An equals check used to prevent copying of the same value by returning {@code this}.
   * @param connectorName A new value for connectorName
   * @return A modified copy of the {@code this} object
   */
  public final ImmutableDescribeConnectorConfigurationResponse withConnectorName(String connectorName) {
    if (this.connectorName.equals(connectorName)) return this;
    String newValue = Preconditions.checkNotNull(connectorName, "connectorName");
    return new ImmutableDescribeConnectorConfigurationResponse(
        this.connectorOwner,
        newValue,
        this.connectorVersion,
        this.connectorModes,
        this.authenticationConfig,
        this.connectorRuntimeSetting,
        this.supportedApiVersions,
        this.operatorsSupported,
        this.supportedTriggerTypes,
        this.triggerFrequenciesSupported,
        this.supportedWriteOperations,
        this.logoURL,
        this.isSuccess,
        this.errorDetails);
  }

  /**
   * Copy the current immutable object by setting a value for the {@link DescribeConnectorConfigurationResponse#connectorVersion() connectorVersion} attribute.
   * An equals check used to prevent copying of the same value by returning {@code this}.
   * @param connectorVersion A new value for connectorVersion
   * @return A modified copy of the {@code this} object
   */
  public final ImmutableDescribeConnectorConfigurationResponse withConnectorVersion(String connectorVersion) {
    if (this.connectorVersion.equals(connectorVersion)) return this;
    String newValue = Preconditions.checkNotNull(connectorVersion, "connectorVersion");
    return new ImmutableDescribeConnectorConfigurationResponse(
        this.connectorOwner,
        this.connectorName,
        newValue,
        this.connectorModes,
        this.authenticationConfig,
        this.connectorRuntimeSetting,
        this.supportedApiVersions,
        this.operatorsSupported,
        this.supportedTriggerTypes,
        this.triggerFrequenciesSupported,
        this.supportedWriteOperations,
        this.logoURL,
        this.isSuccess,
        this.errorDetails);
  }

  /**
   * Copy the current immutable object with elements that replace the content of {@link DescribeConnectorConfigurationResponse#connectorModes() connectorModes}.
   * @param elements The elements to set
   * @return A modified copy of {@code this} object
   */
  public final ImmutableDescribeConnectorConfigurationResponse withConnectorModes(ConnectorModes... elements) {
    ImmutableList<ConnectorModes> newValue = ImmutableList.copyOf(elements);
    return new ImmutableDescribeConnectorConfigurationResponse(
        this.connectorOwner,
        this.connectorName,
        this.connectorVersion,
        newValue,
        this.authenticationConfig,
        this.connectorRuntimeSetting,
        this.supportedApiVersions,
        this.operatorsSupported,
        this.supportedTriggerTypes,
        this.triggerFrequenciesSupported,
        this.supportedWriteOperations,
        this.logoURL,
        this.isSuccess,
        this.errorDetails);
  }

  /**
   * Copy the current immutable object with elements that replace the content of {@link DescribeConnectorConfigurationResponse#connectorModes() connectorModes}.
   * A shallow reference equality check is used to prevent copying of the same value by returning {@code this}.
   * @param elements An iterable of connectorModes elements to set
   * @return A modified copy of {@code this} object
   */
  public final ImmutableDescribeConnectorConfigurationResponse withConnectorModes(Iterable<? extends ConnectorModes> elements) {
    if (this.connectorModes == elements) return this;
    ImmutableList<ConnectorModes> newValue = ImmutableList.copyOf(elements);
    return new ImmutableDescribeConnectorConfigurationResponse(
        this.connectorOwner,
        this.connectorName,
        this.connectorVersion,
        newValue,
        this.authenticationConfig,
        this.connectorRuntimeSetting,
        this.supportedApiVersions,
        this.operatorsSupported,
        this.supportedTriggerTypes,
        this.triggerFrequenciesSupported,
        this.supportedWriteOperations,
        this.logoURL,
        this.isSuccess,
        this.errorDetails);
  }

  /**
   * Copy the current immutable object by setting a value for the {@link DescribeConnectorConfigurationResponse#authenticationConfig() authenticationConfig} attribute.
   * A shallow reference equality check is used to prevent copying of the same value by returning {@code this}.
   * @param authenticationConfig A new value for authenticationConfig (can be {@code null})
   * @return A modified copy of the {@code this} object
   */
  public final ImmutableDescribeConnectorConfigurationResponse withAuthenticationConfig(@Nullable AuthenticationConfig authenticationConfig) {
    if (this.authenticationConfig == authenticationConfig) return this;
    return new ImmutableDescribeConnectorConfigurationResponse(
        this.connectorOwner,
        this.connectorName,
        this.connectorVersion,
        this.connectorModes,
        authenticationConfig,
        this.connectorRuntimeSetting,
        this.supportedApiVersions,
        this.operatorsSupported,
        this.supportedTriggerTypes,
        this.triggerFrequenciesSupported,
        this.supportedWriteOperations,
        this.logoURL,
        this.isSuccess,
        this.errorDetails);
  }

  /**
   * Copy the current immutable object with elements that replace the content of {@link DescribeConnectorConfigurationResponse#connectorRuntimeSetting() connectorRuntimeSetting}.
   * @param elements The elements to set
   * @return A modified copy of {@code this} object
   */
  public final ImmutableDescribeConnectorConfigurationResponse withConnectorRuntimeSetting(@Nullable ConnectorRuntimeSetting... elements) {
    if (elements == null) {
      return new ImmutableDescribeConnectorConfigurationResponse(
          this.connectorOwner,
          this.connectorName,
          this.connectorVersion,
          this.connectorModes,
          this.authenticationConfig,
          null,
          this.supportedApiVersions,
          this.operatorsSupported,
          this.supportedTriggerTypes,
          this.triggerFrequenciesSupported,
          this.supportedWriteOperations,
          this.logoURL,
          this.isSuccess,
          this.errorDetails);
    }
    @Nullable ImmutableList<ConnectorRuntimeSetting> newValue = elements == null ? null : ImmutableList.copyOf(elements);
    return new ImmutableDescribeConnectorConfigurationResponse(
        this.connectorOwner,
        this.connectorName,
        this.connectorVersion,
        this.connectorModes,
        this.authenticationConfig,
        newValue,
        this.supportedApiVersions,
        this.operatorsSupported,
        this.supportedTriggerTypes,
        this.triggerFrequenciesSupported,
        this.supportedWriteOperations,
        this.logoURL,
        this.isSuccess,
        this.errorDetails);
  }

  /**
   * Copy the current immutable object with elements that replace the content of {@link DescribeConnectorConfigurationResponse#connectorRuntimeSetting() connectorRuntimeSetting}.
   * A shallow reference equality check is used to prevent copying of the same value by returning {@code this}.
   * @param elements An iterable of connectorRuntimeSetting elements to set
   * @return A modified copy of {@code this} object
   */
  public final ImmutableDescribeConnectorConfigurationResponse withConnectorRuntimeSetting(@Nullable Iterable<? extends ConnectorRuntimeSetting> elements) {
    if (this.connectorRuntimeSetting == elements) return this;
    @Nullable ImmutableList<ConnectorRuntimeSetting> newValue = elements == null ? null : ImmutableList.copyOf(elements);
    return new ImmutableDescribeConnectorConfigurationResponse(
        this.connectorOwner,
        this.connectorName,
        this.connectorVersion,
        this.connectorModes,
        this.authenticationConfig,
        newValue,
        this.supportedApiVersions,
        this.operatorsSupported,
        this.supportedTriggerTypes,
        this.triggerFrequenciesSupported,
        this.supportedWriteOperations,
        this.logoURL,
        this.isSuccess,
        this.errorDetails);
  }

  /**
   * Copy the current immutable object with elements that replace the content of {@link DescribeConnectorConfigurationResponse#supportedApiVersions() supportedApiVersions}.
   * @param elements The elements to set
   * @return A modified copy of {@code this} object
   */
  public final ImmutableDescribeConnectorConfigurationResponse withSupportedApiVersions(String... elements) {
    ImmutableList<String> newValue = ImmutableList.copyOf(elements);
    return new ImmutableDescribeConnectorConfigurationResponse(
        this.connectorOwner,
        this.connectorName,
        this.connectorVersion,
        this.connectorModes,
        this.authenticationConfig,
        this.connectorRuntimeSetting,
        newValue,
        this.operatorsSupported,
        this.supportedTriggerTypes,
        this.triggerFrequenciesSupported,
        this.supportedWriteOperations,
        this.logoURL,
        this.isSuccess,
        this.errorDetails);
  }

  /**
   * Copy the current immutable object with elements that replace the content of {@link DescribeConnectorConfigurationResponse#supportedApiVersions() supportedApiVersions}.
   * A shallow reference equality check is used to prevent copying of the same value by returning {@code this}.
   * @param elements An iterable of supportedApiVersions elements to set
   * @return A modified copy of {@code this} object
   */
  public final ImmutableDescribeConnectorConfigurationResponse withSupportedApiVersions(Iterable<String> elements) {
    if (this.supportedApiVersions == elements) return this;
    ImmutableList<String> newValue = ImmutableList.copyOf(elements);
    return new ImmutableDescribeConnectorConfigurationResponse(
        this.connectorOwner,
        this.connectorName,
        this.connectorVersion,
        this.connectorModes,
        this.authenticationConfig,
        this.connectorRuntimeSetting,
        newValue,
        this.operatorsSupported,
        this.supportedTriggerTypes,
        this.triggerFrequenciesSupported,
        this.supportedWriteOperations,
        this.logoURL,
        this.isSuccess,
        this.errorDetails);
  }

  /**
   * Copy the current immutable object with elements that replace the content of {@link DescribeConnectorConfigurationResponse#operatorsSupported() operatorsSupported}.
   * @param elements The elements to set
   * @return A modified copy of {@code this} object
   */
  public final ImmutableDescribeConnectorConfigurationResponse withOperatorsSupported(ConnectorOperator... elements) {
    ImmutableList<ConnectorOperator> newValue = ImmutableList.copyOf(elements);
    return new ImmutableDescribeConnectorConfigurationResponse(
        this.connectorOwner,
        this.connectorName,
        this.connectorVersion,
        this.connectorModes,
        this.authenticationConfig,
        this.connectorRuntimeSetting,
        this.supportedApiVersions,
        newValue,
        this.supportedTriggerTypes,
        this.triggerFrequenciesSupported,
        this.supportedWriteOperations,
        this.logoURL,
        this.isSuccess,
        this.errorDetails);
  }

  /**
   * Copy the current immutable object with elements that replace the content of {@link DescribeConnectorConfigurationResponse#operatorsSupported() operatorsSupported}.
   * A shallow reference equality check is used to prevent copying of the same value by returning {@code this}.
   * @param elements An iterable of operatorsSupported elements to set
   * @return A modified copy of {@code this} object
   */
  public final ImmutableDescribeConnectorConfigurationResponse withOperatorsSupported(Iterable<? extends ConnectorOperator> elements) {
    if (this.operatorsSupported == elements) return this;
    ImmutableList<ConnectorOperator> newValue = ImmutableList.copyOf(elements);
    return new ImmutableDescribeConnectorConfigurationResponse(
        this.connectorOwner,
        this.connectorName,
        this.connectorVersion,
        this.connectorModes,
        this.authenticationConfig,
        this.connectorRuntimeSetting,
        this.supportedApiVersions,
        newValue,
        this.supportedTriggerTypes,
        this.triggerFrequenciesSupported,
        this.supportedWriteOperations,
        this.logoURL,
        this.isSuccess,
        this.errorDetails);
  }

  /**
   * Copy the current immutable object with elements that replace the content of {@link DescribeConnectorConfigurationResponse#supportedTriggerTypes() supportedTriggerTypes}.
   * @param elements The elements to set
   * @return A modified copy of {@code this} object
   */
  public final ImmutableDescribeConnectorConfigurationResponse withSupportedTriggerTypes(TriggerType... elements) {
    ImmutableList<TriggerType> newValue = ImmutableList.copyOf(elements);
    return new ImmutableDescribeConnectorConfigurationResponse(
        this.connectorOwner,
        this.connectorName,
        this.connectorVersion,
        this.connectorModes,
        this.authenticationConfig,
        this.connectorRuntimeSetting,
        this.supportedApiVersions,
        this.operatorsSupported,
        newValue,
        this.triggerFrequenciesSupported,
        this.supportedWriteOperations,
        this.logoURL,
        this.isSuccess,
        this.errorDetails);
  }

  /**
   * Copy the current immutable object with elements that replace the content of {@link DescribeConnectorConfigurationResponse#supportedTriggerTypes() supportedTriggerTypes}.
   * A shallow reference equality check is used to prevent copying of the same value by returning {@code this}.
   * @param elements An iterable of supportedTriggerTypes elements to set
   * @return A modified copy of {@code this} object
   */
  public final ImmutableDescribeConnectorConfigurationResponse withSupportedTriggerTypes(Iterable<? extends TriggerType> elements) {
    if (this.supportedTriggerTypes == elements) return this;
    ImmutableList<TriggerType> newValue = ImmutableList.copyOf(elements);
    return new ImmutableDescribeConnectorConfigurationResponse(
        this.connectorOwner,
        this.connectorName,
        this.connectorVersion,
        this.connectorModes,
        this.authenticationConfig,
        this.connectorRuntimeSetting,
        this.supportedApiVersions,
        this.operatorsSupported,
        newValue,
        this.triggerFrequenciesSupported,
        this.supportedWriteOperations,
        this.logoURL,
        this.isSuccess,
        this.errorDetails);
  }

  /**
   * Copy the current immutable object with elements that replace the content of {@link DescribeConnectorConfigurationResponse#triggerFrequenciesSupported() triggerFrequenciesSupported}.
   * @param elements The elements to set
   * @return A modified copy of {@code this} object
   */
  public final ImmutableDescribeConnectorConfigurationResponse withTriggerFrequenciesSupported(TriggerFrequency... elements) {
    ImmutableList<TriggerFrequency> newValue = ImmutableList.copyOf(elements);
    return new ImmutableDescribeConnectorConfigurationResponse(
        this.connectorOwner,
        this.connectorName,
        this.connectorVersion,
        this.connectorModes,
        this.authenticationConfig,
        this.connectorRuntimeSetting,
        this.supportedApiVersions,
        this.operatorsSupported,
        this.supportedTriggerTypes,
        newValue,
        this.supportedWriteOperations,
        this.logoURL,
        this.isSuccess,
        this.errorDetails);
  }

  /**
   * Copy the current immutable object with elements that replace the content of {@link DescribeConnectorConfigurationResponse#triggerFrequenciesSupported() triggerFrequenciesSupported}.
   * A shallow reference equality check is used to prevent copying of the same value by returning {@code this}.
   * @param elements An iterable of triggerFrequenciesSupported elements to set
   * @return A modified copy of {@code this} object
   */
  public final ImmutableDescribeConnectorConfigurationResponse withTriggerFrequenciesSupported(Iterable<? extends TriggerFrequency> elements) {
    if (this.triggerFrequenciesSupported == elements) return this;
    ImmutableList<TriggerFrequency> newValue = ImmutableList.copyOf(elements);
    return new ImmutableDescribeConnectorConfigurationResponse(
        this.connectorOwner,
        this.connectorName,
        this.connectorVersion,
        this.connectorModes,
        this.authenticationConfig,
        this.connectorRuntimeSetting,
        this.supportedApiVersions,
        this.operatorsSupported,
        this.supportedTriggerTypes,
        newValue,
        this.supportedWriteOperations,
        this.logoURL,
        this.isSuccess,
        this.errorDetails);
  }

  /**
   * Copy the current immutable object with elements that replace the content of {@link DescribeConnectorConfigurationResponse#supportedWriteOperations() supportedWriteOperations}.
   * @param elements The elements to set
   * @return A modified copy of {@code this} object
   */
  public final ImmutableDescribeConnectorConfigurationResponse withSupportedWriteOperations(WriteOperationType... elements) {
    ImmutableList<WriteOperationType> newValue = ImmutableList.copyOf(elements);
    return new ImmutableDescribeConnectorConfigurationResponse(
        this.connectorOwner,
        this.connectorName,
        this.connectorVersion,
        this.connectorModes,
        this.authenticationConfig,
        this.connectorRuntimeSetting,
        this.supportedApiVersions,
        this.operatorsSupported,
        this.supportedTriggerTypes,
        this.triggerFrequenciesSupported,
        newValue,
        this.logoURL,
        this.isSuccess,
        this.errorDetails);
  }

  /**
   * Copy the current immutable object with elements that replace the content of {@link DescribeConnectorConfigurationResponse#supportedWriteOperations() supportedWriteOperations}.
   * A shallow reference equality check is used to prevent copying of the same value by returning {@code this}.
   * @param elements An iterable of supportedWriteOperations elements to set
   * @return A modified copy of {@code this} object
   */
  public final ImmutableDescribeConnectorConfigurationResponse withSupportedWriteOperations(Iterable<? extends WriteOperationType> elements) {
    if (this.supportedWriteOperations == elements) return this;
    ImmutableList<WriteOperationType> newValue = ImmutableList.copyOf(elements);
    return new ImmutableDescribeConnectorConfigurationResponse(
        this.connectorOwner,
        this.connectorName,
        this.connectorVersion,
        this.connectorModes,
        this.authenticationConfig,
        this.connectorRuntimeSetting,
        this.supportedApiVersions,
        this.operatorsSupported,
        this.supportedTriggerTypes,
        this.triggerFrequenciesSupported,
        newValue,
        this.logoURL,
        this.isSuccess,
        this.errorDetails);
  }

  /**
   * Copy the current immutable object by setting a value for the {@link DescribeConnectorConfigurationResponse#logoURL() logoURL} attribute.
   * An equals check used to prevent copying of the same value by returning {@code this}.
   * @param logoURL A new value for logoURL (can be {@code null})
   * @return A modified copy of the {@code this} object
   */
  public final ImmutableDescribeConnectorConfigurationResponse withLogoURL(@Nullable String logoURL) {
    if (Objects.equal(this.logoURL, logoURL)) return this;
    return new ImmutableDescribeConnectorConfigurationResponse(
        this.connectorOwner,
        this.connectorName,
        this.connectorVersion,
        this.connectorModes,
        this.authenticationConfig,
        this.connectorRuntimeSetting,
        this.supportedApiVersions,
        this.operatorsSupported,
        this.supportedTriggerTypes,
        this.triggerFrequenciesSupported,
        this.supportedWriteOperations,
        logoURL,
        this.isSuccess,
        this.errorDetails);
  }

  /**
   * Copy the current immutable object by setting a value for the {@link DescribeConnectorConfigurationResponse#isSuccess() isSuccess} attribute.
   * A value equality check is used to prevent copying of the same value by returning {@code this}.
   * @param isSuccess A new value for isSuccess
   * @return A modified copy of the {@code this} object
   */
  public final ImmutableDescribeConnectorConfigurationResponse withIsSuccess(boolean isSuccess) {
    if (this.isSuccess == isSuccess) return this;
    return new ImmutableDescribeConnectorConfigurationResponse(
        this.connectorOwner,
        this.connectorName,
        this.connectorVersion,
        this.connectorModes,
        this.authenticationConfig,
        this.connectorRuntimeSetting,
        this.supportedApiVersions,
        this.operatorsSupported,
        this.supportedTriggerTypes,
        this.triggerFrequenciesSupported,
        this.supportedWriteOperations,
        this.logoURL,
        isSuccess,
        this.errorDetails);
  }

  /**
   * Copy the current immutable object by setting a value for the {@link DescribeConnectorConfigurationResponse#errorDetails() errorDetails} attribute.
   * A shallow reference equality check is used to prevent copying of the same value by returning {@code this}.
   * @param errorDetails A new value for errorDetails (can be {@code null})
   * @return A modified copy of the {@code this} object
   */
  public final ImmutableDescribeConnectorConfigurationResponse withErrorDetails(@Nullable ErrorDetails errorDetails) {
    if (this.errorDetails == errorDetails) return this;
    return new ImmutableDescribeConnectorConfigurationResponse(
        this.connectorOwner,
        this.connectorName,
        this.connectorVersion,
        this.connectorModes,
        this.authenticationConfig,
        this.connectorRuntimeSetting,
        this.supportedApiVersions,
        this.operatorsSupported,
        this.supportedTriggerTypes,
        this.triggerFrequenciesSupported,
        this.supportedWriteOperations,
        this.logoURL,
        this.isSuccess,
        errorDetails);
  }

  /**
   * This instance is equal to all instances of {@code ImmutableDescribeConnectorConfigurationResponse} that have equal attribute values.
   * @return {@code true} if {@code this} is equal to {@code another} instance
   */
  @Override
  public boolean equals(@Nullable Object another) {
    if (this == another) return true;
    return another instanceof ImmutableDescribeConnectorConfigurationResponse
        && equalTo((ImmutableDescribeConnectorConfigurationResponse) another);
  }

  private boolean equalTo(ImmutableDescribeConnectorConfigurationResponse another) {
    return connectorOwner.equals(another.connectorOwner)
        && connectorName.equals(another.connectorName)
        && connectorVersion.equals(another.connectorVersion)
        && connectorModes.equals(another.connectorModes)
        && Objects.equal(authenticationConfig, another.authenticationConfig)
        && Objects.equal(connectorRuntimeSetting, another.connectorRuntimeSetting)
        && supportedApiVersions.equals(another.supportedApiVersions)
        && operatorsSupported.equals(another.operatorsSupported)
        && supportedTriggerTypes.equals(another.supportedTriggerTypes)
        && triggerFrequenciesSupported.equals(another.triggerFrequenciesSupported)
        && supportedWriteOperations.equals(another.supportedWriteOperations)
        && Objects.equal(logoURL, another.logoURL)
        && isSuccess == another.isSuccess
        && Objects.equal(errorDetails, another.errorDetails);
  }

  /**
   * Computes a hash code from attributes: {@code connectorOwner}, {@code connectorName}, {@code connectorVersion}, {@code connectorModes}, {@code authenticationConfig}, {@code connectorRuntimeSetting}, {@code supportedApiVersions}, {@code operatorsSupported}, {@code supportedTriggerTypes}, {@code triggerFrequenciesSupported}, {@code supportedWriteOperations}, {@code logoURL}, {@code isSuccess}, {@code errorDetails}.
   * @return hashCode value
   */
  @Override
  public int hashCode() {
    int h = 31;
    h = h * 17 + connectorOwner.hashCode();
    h = h * 17 + connectorName.hashCode();
    h = h * 17 + connectorVersion.hashCode();
    h = h * 17 + connectorModes.hashCode();
    h = h * 17 + Objects.hashCode(authenticationConfig);
    h = h * 17 + Objects.hashCode(connectorRuntimeSetting);
    h = h * 17 + supportedApiVersions.hashCode();
    h = h * 17 + operatorsSupported.hashCode();
    h = h * 17 + supportedTriggerTypes.hashCode();
    h = h * 17 + triggerFrequenciesSupported.hashCode();
    h = h * 17 + supportedWriteOperations.hashCode();
    h = h * 17 + Objects.hashCode(logoURL);
    h = h * 17 + Booleans.hashCode(isSuccess);
    h = h * 17 + Objects.hashCode(errorDetails);
    return h;
  }

  /**
   * Prints the immutable value {@code DescribeConnectorConfigurationResponse} with attribute values.
   * @return A string representation of the value
   */
  @Override
  public String toString() {
    return MoreObjects.toStringHelper("DescribeConnectorConfigurationResponse")
        .omitNullValues()
        .add("connectorOwner", connectorOwner)
        .add("connectorName", connectorName)
        .add("connectorVersion", connectorVersion)
        .add("connectorModes", connectorModes)
        .add("authenticationConfig", authenticationConfig)
        .add("connectorRuntimeSetting", connectorRuntimeSetting)
        .add("supportedApiVersions", supportedApiVersions)
        .add("operatorsSupported", operatorsSupported)
        .add("supportedTriggerTypes", supportedTriggerTypes)
        .add("triggerFrequenciesSupported", triggerFrequenciesSupported)
        .add("supportedWriteOperations", supportedWriteOperations)
        .add("logoURL", logoURL)
        .add("isSuccess", isSuccess)
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
      implements DescribeConnectorConfigurationResponse {
    @Nullable String connectorOwner;
    @Nullable String connectorName;
    @Nullable String connectorVersion;
    List<ConnectorModes> connectorModes = ImmutableList.of();
    @Nullable AuthenticationConfig authenticationConfig;
    List<ConnectorRuntimeSetting> connectorRuntimeSetting = null;
    List<String> supportedApiVersions = ImmutableList.of();
    List<ConnectorOperator> operatorsSupported = ImmutableList.of();
    boolean operatorsSupportedIsSet;
    List<TriggerType> supportedTriggerTypes = ImmutableList.of();
    boolean supportedTriggerTypesIsSet;
    List<TriggerFrequency> triggerFrequenciesSupported = ImmutableList.of();
    boolean triggerFrequenciesSupportedIsSet;
    List<WriteOperationType> supportedWriteOperations = ImmutableList.of();
    boolean supportedWriteOperationsIsSet;
    @Nullable String logoURL;
    boolean isSuccess;
    boolean isSuccessIsSet;
    @Nullable ErrorDetails errorDetails;
    @JsonProperty("connectorOwner")
    public void setConnectorOwner(String connectorOwner) {
      this.connectorOwner = connectorOwner;
    }
    @JsonProperty("connectorName")
    public void setConnectorName(String connectorName) {
      this.connectorName = connectorName;
    }
    @JsonProperty("connectorVersion")
    public void setConnectorVersion(String connectorVersion) {
      this.connectorVersion = connectorVersion;
    }
    @JsonProperty("connectorModes")
    public void setConnectorModes(List<ConnectorModes> connectorModes) {
      this.connectorModes = connectorModes;
    }
    @JsonProperty("authenticationConfig")
    public void setAuthenticationConfig(@Nullable AuthenticationConfig authenticationConfig) {
      this.authenticationConfig = authenticationConfig;
    }
    @JsonProperty("connectorRuntimeSetting")
    public void setConnectorRuntimeSetting(@Nullable List<ConnectorRuntimeSetting> connectorRuntimeSetting) {
      this.connectorRuntimeSetting = connectorRuntimeSetting;
    }
    @JsonProperty("supportedApiVersions")
    public void setSupportedApiVersions(List<String> supportedApiVersions) {
      this.supportedApiVersions = supportedApiVersions;
    }
    @JsonProperty("operatorsSupported")
    public void setOperatorsSupported(List<ConnectorOperator> operatorsSupported) {
      this.operatorsSupported = operatorsSupported;
      this.operatorsSupportedIsSet = true;
    }
    @JsonProperty("supportedTriggerTypes")
    public void setSupportedTriggerTypes(List<TriggerType> supportedTriggerTypes) {
      this.supportedTriggerTypes = supportedTriggerTypes;
      this.supportedTriggerTypesIsSet = true;
    }
    @JsonProperty("triggerFrequenciesSupported")
    public void setTriggerFrequenciesSupported(List<TriggerFrequency> triggerFrequenciesSupported) {
      this.triggerFrequenciesSupported = triggerFrequenciesSupported;
      this.triggerFrequenciesSupportedIsSet = true;
    }
    @JsonProperty("supportedWriteOperations")
    public void setSupportedWriteOperations(List<WriteOperationType> supportedWriteOperations) {
      this.supportedWriteOperations = supportedWriteOperations;
      this.supportedWriteOperationsIsSet = true;
    }
    @JsonProperty("logoURL")
    public void setLogoURL(@Nullable String logoURL) {
      this.logoURL = logoURL;
    }
    @JsonProperty("isSuccess")
    public void setIsSuccess(boolean isSuccess) {
      this.isSuccess = isSuccess;
      this.isSuccessIsSet = true;
    }
    @JsonProperty("errorDetails")
    public void setErrorDetails(@Nullable ErrorDetails errorDetails) {
      this.errorDetails = errorDetails;
    }
    @Override
    public String connectorOwner() { throw new UnsupportedOperationException(); }
    @Override
    public String connectorName() { throw new UnsupportedOperationException(); }
    @Override
    public String connectorVersion() { throw new UnsupportedOperationException(); }
    @Override
    public List<ConnectorModes> connectorModes() { throw new UnsupportedOperationException(); }
    @Override
    public AuthenticationConfig authenticationConfig() { throw new UnsupportedOperationException(); }
    @Override
    public List<ConnectorRuntimeSetting> connectorRuntimeSetting() { throw new UnsupportedOperationException(); }
    @Override
    public List<String> supportedApiVersions() { throw new UnsupportedOperationException(); }
    @Override
    public List<ConnectorOperator> operatorsSupported() { throw new UnsupportedOperationException(); }
    @Override
    public List<TriggerType> supportedTriggerTypes() { throw new UnsupportedOperationException(); }
    @Override
    public List<TriggerFrequency> triggerFrequenciesSupported() { throw new UnsupportedOperationException(); }
    @Override
    public List<WriteOperationType> supportedWriteOperations() { throw new UnsupportedOperationException(); }
    @Override
    public String logoURL() { throw new UnsupportedOperationException(); }
    @Override
    public boolean isSuccess() { throw new UnsupportedOperationException(); }
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
  static ImmutableDescribeConnectorConfigurationResponse fromJson(Json json) {
    ImmutableDescribeConnectorConfigurationResponse.Builder builder = ImmutableDescribeConnectorConfigurationResponse.builder();
    if (json.connectorOwner != null) {
      builder.connectorOwner(json.connectorOwner);
    }
    if (json.connectorName != null) {
      builder.connectorName(json.connectorName);
    }
    if (json.connectorVersion != null) {
      builder.connectorVersion(json.connectorVersion);
    }
    if (json.connectorModes != null) {
      builder.addAllConnectorModes(json.connectorModes);
    }
    if (json.authenticationConfig != null) {
      builder.authenticationConfig(json.authenticationConfig);
    }
    if (json.connectorRuntimeSetting != null) {
      builder.addAllConnectorRuntimeSetting(json.connectorRuntimeSetting);
    }
    if (json.supportedApiVersions != null) {
      builder.addAllSupportedApiVersions(json.supportedApiVersions);
    }
    if (json.operatorsSupportedIsSet) {
      builder.operatorsSupported(json.operatorsSupported);
    }
    if (json.supportedTriggerTypesIsSet) {
      builder.supportedTriggerTypes(json.supportedTriggerTypes);
    }
    if (json.triggerFrequenciesSupportedIsSet) {
      builder.triggerFrequenciesSupported(json.triggerFrequenciesSupported);
    }
    if (json.supportedWriteOperationsIsSet) {
      builder.supportedWriteOperations(json.supportedWriteOperations);
    }
    if (json.logoURL != null) {
      builder.logoURL(json.logoURL);
    }
    if (json.isSuccessIsSet) {
      builder.isSuccess(json.isSuccess);
    }
    if (json.errorDetails != null) {
      builder.errorDetails(json.errorDetails);
    }
    return builder.build();
  }

  /**
   * Creates an immutable copy of a {@link DescribeConnectorConfigurationResponse} value.
   * Uses accessors to get values to initialize the new immutable instance.
   * If an instance is already immutable, it is returned as is.
   * @param instance The instance to copy
   * @return A copied immutable DescribeConnectorConfigurationResponse instance
   */
  public static ImmutableDescribeConnectorConfigurationResponse copyOf(DescribeConnectorConfigurationResponse instance) {
    if (instance instanceof ImmutableDescribeConnectorConfigurationResponse) {
      return (ImmutableDescribeConnectorConfigurationResponse) instance;
    }
    return ImmutableDescribeConnectorConfigurationResponse.builder()
        .from(instance)
        .build();
  }

  /**
   * Creates a builder for {@link ImmutableDescribeConnectorConfigurationResponse ImmutableDescribeConnectorConfigurationResponse}.
   * @return A new ImmutableDescribeConnectorConfigurationResponse builder
   */
  public static ImmutableDescribeConnectorConfigurationResponse.Builder builder() {
    return new ImmutableDescribeConnectorConfigurationResponse.Builder();
  }

  /**
   * Builds instances of type {@link ImmutableDescribeConnectorConfigurationResponse ImmutableDescribeConnectorConfigurationResponse}.
   * Initialize attributes and then invoke the {@link #build()} method to create an
   * immutable instance.
   * <p><em>{@code Builder} is not thread-safe and generally should not be stored in a field or collection,
   * but instead used immediately to create instances.</em>
   */
  @NotThreadSafe
  public static final class Builder {
    private static final long INIT_BIT_CONNECTOR_OWNER = 0x1L;
    private static final long INIT_BIT_CONNECTOR_NAME = 0x2L;
    private static final long INIT_BIT_CONNECTOR_VERSION = 0x4L;
    private static final long INIT_BIT_IS_SUCCESS = 0x8L;
    private static final long OPT_BIT_OPERATORS_SUPPORTED = 0x1L;
    private static final long OPT_BIT_SUPPORTED_TRIGGER_TYPES = 0x2L;
    private static final long OPT_BIT_TRIGGER_FREQUENCIES_SUPPORTED = 0x4L;
    private static final long OPT_BIT_SUPPORTED_WRITE_OPERATIONS = 0x8L;
    private long initBits = 0xfL;
    private long optBits;

    private @Nullable String connectorOwner;
    private @Nullable String connectorName;
    private @Nullable String connectorVersion;
    private ImmutableList.Builder<ConnectorModes> connectorModes = ImmutableList.builder();
    private @Nullable AuthenticationConfig authenticationConfig;
    private ImmutableList.Builder<ConnectorRuntimeSetting> connectorRuntimeSetting = null;
    private ImmutableList.Builder<String> supportedApiVersions = ImmutableList.builder();
    private ImmutableList.Builder<ConnectorOperator> operatorsSupported = ImmutableList.builder();
    private ImmutableList.Builder<TriggerType> supportedTriggerTypes = ImmutableList.builder();
    private ImmutableList.Builder<TriggerFrequency> triggerFrequenciesSupported = ImmutableList.builder();
    private ImmutableList.Builder<WriteOperationType> supportedWriteOperations = ImmutableList.builder();
    private @Nullable String logoURL;
    private boolean isSuccess;
    private @Nullable ErrorDetails errorDetails;

    private Builder() {
    }

    /**
     * Fill a builder with attribute values from the provided {@code DescribeConnectorConfigurationResponse} instance.
     * Regular attribute values will be replaced with those from the given instance.
     * Absent optional values will not replace present values.
     * Collection elements and entries will be added, not replaced.
     * @param instance The instance from which to copy values
     * @return {@code this} builder for use in a chained invocation
     */
    public final Builder from(DescribeConnectorConfigurationResponse instance) {
      Preconditions.checkNotNull(instance, "instance");
      connectorOwner(instance.connectorOwner());
      connectorName(instance.connectorName());
      connectorVersion(instance.connectorVersion());
      addAllConnectorModes(instance.connectorModes());
      @Nullable AuthenticationConfig authenticationConfigValue = instance.authenticationConfig();
      if (authenticationConfigValue != null) {
        authenticationConfig(authenticationConfigValue);
      }
      @Nullable List<ConnectorRuntimeSetting> connectorRuntimeSettingValue = instance.connectorRuntimeSetting();
      if (connectorRuntimeSettingValue != null) {
        addAllConnectorRuntimeSetting(connectorRuntimeSettingValue);
      }
      addAllSupportedApiVersions(instance.supportedApiVersions());
      addAllOperatorsSupported(instance.operatorsSupported());
      addAllSupportedTriggerTypes(instance.supportedTriggerTypes());
      addAllTriggerFrequenciesSupported(instance.triggerFrequenciesSupported());
      addAllSupportedWriteOperations(instance.supportedWriteOperations());
      @Nullable String logoURLValue = instance.logoURL();
      if (logoURLValue != null) {
        logoURL(logoURLValue);
      }
      isSuccess(instance.isSuccess());
      @Nullable ErrorDetails errorDetailsValue = instance.errorDetails();
      if (errorDetailsValue != null) {
        errorDetails(errorDetailsValue);
      }
      return this;
    }

    /**
     * Initializes the value for the {@link DescribeConnectorConfigurationResponse#connectorOwner() connectorOwner} attribute.
     * @param connectorOwner The value for connectorOwner 
     * @return {@code this} builder for use in a chained invocation
     */
    public final Builder connectorOwner(String connectorOwner) {
      this.connectorOwner = Preconditions.checkNotNull(connectorOwner, "connectorOwner");
      initBits &= ~INIT_BIT_CONNECTOR_OWNER;
      return this;
    }

    /**
     * Initializes the value for the {@link DescribeConnectorConfigurationResponse#connectorName() connectorName} attribute.
     * @param connectorName The value for connectorName 
     * @return {@code this} builder for use in a chained invocation
     */
    public final Builder connectorName(String connectorName) {
      this.connectorName = Preconditions.checkNotNull(connectorName, "connectorName");
      initBits &= ~INIT_BIT_CONNECTOR_NAME;
      return this;
    }

    /**
     * Initializes the value for the {@link DescribeConnectorConfigurationResponse#connectorVersion() connectorVersion} attribute.
     * @param connectorVersion The value for connectorVersion 
     * @return {@code this} builder for use in a chained invocation
     */
    public final Builder connectorVersion(String connectorVersion) {
      this.connectorVersion = Preconditions.checkNotNull(connectorVersion, "connectorVersion");
      initBits &= ~INIT_BIT_CONNECTOR_VERSION;
      return this;
    }

    /**
     * Adds one element to {@link DescribeConnectorConfigurationResponse#connectorModes() connectorModes} list.
     * @param element A connectorModes element
     * @return {@code this} builder for use in a chained invocation
     */
    public final Builder addConnectorModes(ConnectorModes element) {
      this.connectorModes.add(element);
      return this;
    }

    /**
     * Adds elements to {@link DescribeConnectorConfigurationResponse#connectorModes() connectorModes} list.
     * @param elements An array of connectorModes elements
     * @return {@code this} builder for use in a chained invocation
     */
    public final Builder addConnectorModes(ConnectorModes... elements) {
      this.connectorModes.add(elements);
      return this;
    }

    /**
     * Sets or replaces all elements for {@link DescribeConnectorConfigurationResponse#connectorModes() connectorModes} list.
     * @param elements An iterable of connectorModes elements
     * @return {@code this} builder for use in a chained invocation
     */
    public final Builder connectorModes(Iterable<? extends ConnectorModes> elements) {
      this.connectorModes = ImmutableList.builder();
      return addAllConnectorModes(elements);
    }

    /**
     * Adds elements to {@link DescribeConnectorConfigurationResponse#connectorModes() connectorModes} list.
     * @param elements An iterable of connectorModes elements
     * @return {@code this} builder for use in a chained invocation
     */
    public final Builder addAllConnectorModes(Iterable<? extends ConnectorModes> elements) {
      this.connectorModes.addAll(elements);
      return this;
    }

    /**
     * Initializes the value for the {@link DescribeConnectorConfigurationResponse#authenticationConfig() authenticationConfig} attribute.
     * @param authenticationConfig The value for authenticationConfig (can be {@code null})
     * @return {@code this} builder for use in a chained invocation
     */
    public final Builder authenticationConfig(@Nullable AuthenticationConfig authenticationConfig) {
      this.authenticationConfig = authenticationConfig;
      return this;
    }

    /**
     * Adds one element to {@link DescribeConnectorConfigurationResponse#connectorRuntimeSetting() connectorRuntimeSetting} list.
     * @param element A connectorRuntimeSetting element
     * @return {@code this} builder for use in a chained invocation
     */
    public final Builder addConnectorRuntimeSetting(ConnectorRuntimeSetting element) {
      if (this.connectorRuntimeSetting == null) {
        this.connectorRuntimeSetting = ImmutableList.builder();
      }
      this.connectorRuntimeSetting.add(element);
      return this;
    }

    /**
     * Adds elements to {@link DescribeConnectorConfigurationResponse#connectorRuntimeSetting() connectorRuntimeSetting} list.
     * @param elements An array of connectorRuntimeSetting elements
     * @return {@code this} builder for use in a chained invocation
     */
    public final Builder addConnectorRuntimeSetting(ConnectorRuntimeSetting... elements) {
      if (this.connectorRuntimeSetting == null) {
        this.connectorRuntimeSetting = ImmutableList.builder();
      }
      this.connectorRuntimeSetting.add(elements);
      return this;
    }

    /**
     * Sets or replaces all elements for {@link DescribeConnectorConfigurationResponse#connectorRuntimeSetting() connectorRuntimeSetting} list.
     * @param elements An iterable of connectorRuntimeSetting elements
     * @return {@code this} builder for use in a chained invocation
     */
    public final Builder connectorRuntimeSetting(@Nullable Iterable<? extends ConnectorRuntimeSetting> elements) {
      if (elements == null) {
        this.connectorRuntimeSetting = null;
        return this;
      }
      this.connectorRuntimeSetting = ImmutableList.builder();
      return addAllConnectorRuntimeSetting(elements);
    }

    /**
     * Adds elements to {@link DescribeConnectorConfigurationResponse#connectorRuntimeSetting() connectorRuntimeSetting} list.
     * @param elements An iterable of connectorRuntimeSetting elements
     * @return {@code this} builder for use in a chained invocation
     */
    public final Builder addAllConnectorRuntimeSetting(Iterable<? extends ConnectorRuntimeSetting> elements) {
      Preconditions.checkNotNull(elements, "connectorRuntimeSetting element");
      if (this.connectorRuntimeSetting == null) {
        this.connectorRuntimeSetting = ImmutableList.builder();
      }
      this.connectorRuntimeSetting.addAll(elements);
      return this;
    }

    /**
     * Adds one element to {@link DescribeConnectorConfigurationResponse#supportedApiVersions() supportedApiVersions} list.
     * @param element A supportedApiVersions element
     * @return {@code this} builder for use in a chained invocation
     */
    public final Builder addSupportedApiVersions(String element) {
      this.supportedApiVersions.add(element);
      return this;
    }

    /**
     * Adds elements to {@link DescribeConnectorConfigurationResponse#supportedApiVersions() supportedApiVersions} list.
     * @param elements An array of supportedApiVersions elements
     * @return {@code this} builder for use in a chained invocation
     */
    public final Builder addSupportedApiVersions(String... elements) {
      this.supportedApiVersions.add(elements);
      return this;
    }

    /**
     * Sets or replaces all elements for {@link DescribeConnectorConfigurationResponse#supportedApiVersions() supportedApiVersions} list.
     * @param elements An iterable of supportedApiVersions elements
     * @return {@code this} builder for use in a chained invocation
     */
    public final Builder supportedApiVersions(Iterable<String> elements) {
      this.supportedApiVersions = ImmutableList.builder();
      return addAllSupportedApiVersions(elements);
    }

    /**
     * Adds elements to {@link DescribeConnectorConfigurationResponse#supportedApiVersions() supportedApiVersions} list.
     * @param elements An iterable of supportedApiVersions elements
     * @return {@code this} builder for use in a chained invocation
     */
    public final Builder addAllSupportedApiVersions(Iterable<String> elements) {
      this.supportedApiVersions.addAll(elements);
      return this;
    }

    /**
     * Adds one element to {@link DescribeConnectorConfigurationResponse#operatorsSupported() operatorsSupported} list.
     * @param element A operatorsSupported element
     * @return {@code this} builder for use in a chained invocation
     */
    public final Builder addOperatorsSupported(ConnectorOperator element) {
      this.operatorsSupported.add(element);
      optBits |= OPT_BIT_OPERATORS_SUPPORTED;
      return this;
    }

    /**
     * Adds elements to {@link DescribeConnectorConfigurationResponse#operatorsSupported() operatorsSupported} list.
     * @param elements An array of operatorsSupported elements
     * @return {@code this} builder for use in a chained invocation
     */
    public final Builder addOperatorsSupported(ConnectorOperator... elements) {
      this.operatorsSupported.add(elements);
      optBits |= OPT_BIT_OPERATORS_SUPPORTED;
      return this;
    }

    /**
     * Sets or replaces all elements for {@link DescribeConnectorConfigurationResponse#operatorsSupported() operatorsSupported} list.
     * @param elements An iterable of operatorsSupported elements
     * @return {@code this} builder for use in a chained invocation
     */
    public final Builder operatorsSupported(Iterable<? extends ConnectorOperator> elements) {
      this.operatorsSupported = ImmutableList.builder();
      return addAllOperatorsSupported(elements);
    }

    /**
     * Adds elements to {@link DescribeConnectorConfigurationResponse#operatorsSupported() operatorsSupported} list.
     * @param elements An iterable of operatorsSupported elements
     * @return {@code this} builder for use in a chained invocation
     */
    public final Builder addAllOperatorsSupported(Iterable<? extends ConnectorOperator> elements) {
      this.operatorsSupported.addAll(elements);
      optBits |= OPT_BIT_OPERATORS_SUPPORTED;
      return this;
    }

    /**
     * Adds one element to {@link DescribeConnectorConfigurationResponse#supportedTriggerTypes() supportedTriggerTypes} list.
     * @param element A supportedTriggerTypes element
     * @return {@code this} builder for use in a chained invocation
     */
    public final Builder addSupportedTriggerTypes(TriggerType element) {
      this.supportedTriggerTypes.add(element);
      optBits |= OPT_BIT_SUPPORTED_TRIGGER_TYPES;
      return this;
    }

    /**
     * Adds elements to {@link DescribeConnectorConfigurationResponse#supportedTriggerTypes() supportedTriggerTypes} list.
     * @param elements An array of supportedTriggerTypes elements
     * @return {@code this} builder for use in a chained invocation
     */
    public final Builder addSupportedTriggerTypes(TriggerType... elements) {
      this.supportedTriggerTypes.add(elements);
      optBits |= OPT_BIT_SUPPORTED_TRIGGER_TYPES;
      return this;
    }

    /**
     * Sets or replaces all elements for {@link DescribeConnectorConfigurationResponse#supportedTriggerTypes() supportedTriggerTypes} list.
     * @param elements An iterable of supportedTriggerTypes elements
     * @return {@code this} builder for use in a chained invocation
     */
    public final Builder supportedTriggerTypes(Iterable<? extends TriggerType> elements) {
      this.supportedTriggerTypes = ImmutableList.builder();
      return addAllSupportedTriggerTypes(elements);
    }

    /**
     * Adds elements to {@link DescribeConnectorConfigurationResponse#supportedTriggerTypes() supportedTriggerTypes} list.
     * @param elements An iterable of supportedTriggerTypes elements
     * @return {@code this} builder for use in a chained invocation
     */
    public final Builder addAllSupportedTriggerTypes(Iterable<? extends TriggerType> elements) {
      this.supportedTriggerTypes.addAll(elements);
      optBits |= OPT_BIT_SUPPORTED_TRIGGER_TYPES;
      return this;
    }

    /**
     * Adds one element to {@link DescribeConnectorConfigurationResponse#triggerFrequenciesSupported() triggerFrequenciesSupported} list.
     * @param element A triggerFrequenciesSupported element
     * @return {@code this} builder for use in a chained invocation
     */
    public final Builder addTriggerFrequenciesSupported(TriggerFrequency element) {
      this.triggerFrequenciesSupported.add(element);
      optBits |= OPT_BIT_TRIGGER_FREQUENCIES_SUPPORTED;
      return this;
    }

    /**
     * Adds elements to {@link DescribeConnectorConfigurationResponse#triggerFrequenciesSupported() triggerFrequenciesSupported} list.
     * @param elements An array of triggerFrequenciesSupported elements
     * @return {@code this} builder for use in a chained invocation
     */
    public final Builder addTriggerFrequenciesSupported(TriggerFrequency... elements) {
      this.triggerFrequenciesSupported.add(elements);
      optBits |= OPT_BIT_TRIGGER_FREQUENCIES_SUPPORTED;
      return this;
    }

    /**
     * Sets or replaces all elements for {@link DescribeConnectorConfigurationResponse#triggerFrequenciesSupported() triggerFrequenciesSupported} list.
     * @param elements An iterable of triggerFrequenciesSupported elements
     * @return {@code this} builder for use in a chained invocation
     */
    public final Builder triggerFrequenciesSupported(Iterable<? extends TriggerFrequency> elements) {
      this.triggerFrequenciesSupported = ImmutableList.builder();
      return addAllTriggerFrequenciesSupported(elements);
    }

    /**
     * Adds elements to {@link DescribeConnectorConfigurationResponse#triggerFrequenciesSupported() triggerFrequenciesSupported} list.
     * @param elements An iterable of triggerFrequenciesSupported elements
     * @return {@code this} builder for use in a chained invocation
     */
    public final Builder addAllTriggerFrequenciesSupported(Iterable<? extends TriggerFrequency> elements) {
      this.triggerFrequenciesSupported.addAll(elements);
      optBits |= OPT_BIT_TRIGGER_FREQUENCIES_SUPPORTED;
      return this;
    }

    /**
     * Adds one element to {@link DescribeConnectorConfigurationResponse#supportedWriteOperations() supportedWriteOperations} list.
     * @param element A supportedWriteOperations element
     * @return {@code this} builder for use in a chained invocation
     */
    public final Builder addSupportedWriteOperations(WriteOperationType element) {
      this.supportedWriteOperations.add(element);
      optBits |= OPT_BIT_SUPPORTED_WRITE_OPERATIONS;
      return this;
    }

    /**
     * Adds elements to {@link DescribeConnectorConfigurationResponse#supportedWriteOperations() supportedWriteOperations} list.
     * @param elements An array of supportedWriteOperations elements
     * @return {@code this} builder for use in a chained invocation
     */
    public final Builder addSupportedWriteOperations(WriteOperationType... elements) {
      this.supportedWriteOperations.add(elements);
      optBits |= OPT_BIT_SUPPORTED_WRITE_OPERATIONS;
      return this;
    }

    /**
     * Sets or replaces all elements for {@link DescribeConnectorConfigurationResponse#supportedWriteOperations() supportedWriteOperations} list.
     * @param elements An iterable of supportedWriteOperations elements
     * @return {@code this} builder for use in a chained invocation
     */
    public final Builder supportedWriteOperations(Iterable<? extends WriteOperationType> elements) {
      this.supportedWriteOperations = ImmutableList.builder();
      return addAllSupportedWriteOperations(elements);
    }

    /**
     * Adds elements to {@link DescribeConnectorConfigurationResponse#supportedWriteOperations() supportedWriteOperations} list.
     * @param elements An iterable of supportedWriteOperations elements
     * @return {@code this} builder for use in a chained invocation
     */
    public final Builder addAllSupportedWriteOperations(Iterable<? extends WriteOperationType> elements) {
      this.supportedWriteOperations.addAll(elements);
      optBits |= OPT_BIT_SUPPORTED_WRITE_OPERATIONS;
      return this;
    }

    /**
     * Initializes the value for the {@link DescribeConnectorConfigurationResponse#logoURL() logoURL} attribute.
     * @param logoURL The value for logoURL (can be {@code null})
     * @return {@code this} builder for use in a chained invocation
     */
    public final Builder logoURL(@Nullable String logoURL) {
      this.logoURL = logoURL;
      return this;
    }

    /**
     * Initializes the value for the {@link DescribeConnectorConfigurationResponse#isSuccess() isSuccess} attribute.
     * @param isSuccess The value for isSuccess 
     * @return {@code this} builder for use in a chained invocation
     */
    public final Builder isSuccess(boolean isSuccess) {
      this.isSuccess = isSuccess;
      initBits &= ~INIT_BIT_IS_SUCCESS;
      return this;
    }

    /**
     * Initializes the value for the {@link DescribeConnectorConfigurationResponse#errorDetails() errorDetails} attribute.
     * @param errorDetails The value for errorDetails (can be {@code null})
     * @return {@code this} builder for use in a chained invocation
     */
    public final Builder errorDetails(@Nullable ErrorDetails errorDetails) {
      this.errorDetails = errorDetails;
      return this;
    }

    /**
     * Builds a new {@link ImmutableDescribeConnectorConfigurationResponse ImmutableDescribeConnectorConfigurationResponse}.
     * @return An immutable instance of DescribeConnectorConfigurationResponse
     * @throws java.lang.IllegalStateException if any required attributes are missing
     */
    public ImmutableDescribeConnectorConfigurationResponse build() {
      if (initBits != 0) {
        throw new IllegalStateException(formatRequiredAttributesMessage());
      }
      return new ImmutableDescribeConnectorConfigurationResponse(this);
    }

    private boolean operatorsSupportedIsSet() {
      return (optBits & OPT_BIT_OPERATORS_SUPPORTED) != 0;
    }

    private boolean supportedTriggerTypesIsSet() {
      return (optBits & OPT_BIT_SUPPORTED_TRIGGER_TYPES) != 0;
    }

    private boolean triggerFrequenciesSupportedIsSet() {
      return (optBits & OPT_BIT_TRIGGER_FREQUENCIES_SUPPORTED) != 0;
    }

    private boolean supportedWriteOperationsIsSet() {
      return (optBits & OPT_BIT_SUPPORTED_WRITE_OPERATIONS) != 0;
    }

    private String formatRequiredAttributesMessage() {
      List<String> attributes = Lists.newArrayList();
      if ((initBits & INIT_BIT_CONNECTOR_OWNER) != 0) attributes.add("connectorOwner");
      if ((initBits & INIT_BIT_CONNECTOR_NAME) != 0) attributes.add("connectorName");
      if ((initBits & INIT_BIT_CONNECTOR_VERSION) != 0) attributes.add("connectorVersion");
      if ((initBits & INIT_BIT_IS_SUCCESS) != 0) attributes.add("isSuccess");
      return "Cannot build DescribeConnectorConfigurationResponse, some of required attributes are not set " + attributes;
    }
  }
}
