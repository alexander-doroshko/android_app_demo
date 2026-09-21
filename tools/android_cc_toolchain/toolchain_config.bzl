"""A do-nothing C++ toolchain for Android target platforms.

`android_binary` resolves a CC toolchain for whatever `--android_platforms` names, even when the
app contains no `cc_library` of its own. This app does not: the only `.so` it ships comes
prebuilt inside an AAR (`androidx.graphics:graphics-path`), which is merely repackaged, never
compiled. So a stub that satisfies toolchain resolution and is never invoked is enough, and it
avoids making the Android NDK a prerequisite of the build.
"""

load("@rules_cc//cc/common:cc_common.bzl", "cc_common")
load("@rules_cc//cc/toolchains:cc_toolchain_config_info.bzl", "CcToolchainConfigInfo")

def _impl(ctx):
    return cc_common.create_cc_toolchain_config_info(
        ctx = ctx,
        toolchain_identifier = "android-stub",
        host_system_name = "local",
        target_system_name = "android",
        target_cpu = "android",
        target_libc = "unknown",
        compiler = "unknown",
        abi_version = "unknown",
        abi_libc_version = "unknown",
    )

android_stub_cc_toolchain_config = rule(
    implementation = _impl,
    attrs = {},
    provides = [CcToolchainConfigInfo],
)
