VTABLE(_Main) {
    <empty>
    Main
}

FUNCTION(_Main_New) {
memo ''
_Main_New:
    _T0 = 4
    parm _T0
    _T1 =  call _Alloc
    _T2 = VTBL <_Main>
    *(_T1 + 0) = _T2
    return _T1
}

FUNCTION(main) {
memo ''
main:
    _T11 = 1
    _T6 = _T11
    parm _T6
    call _PrintInt
    _T12 = "\n"
    parm _T12
    call _PrintString
    _T13 = 3
    _T14 = "12j"
    _T15 = (_T13 + _T14)
    _T3 = _T15
    _T16 = "\n"
    parm _T16
    call _PrintString
    _T17 = 3
    _T18 = "45j"
    _T19 = (_T17 + _T18)
    _T5 = _T19
    _T20 = ! _T3
    _T7 = _T20
    _T21 = ! _T3
    _T8 = _T21
    parm _T7
    call _PrintInt
    parm _T8
    call _PrintInt
    _T22 = "\n"
    parm _T22
    call _PrintString
    _T23 = (_T7 + _T8)
    _T24 = ! _T23
    _T4 = _T24
    _T25 = "\n"
    parm _T25
    call _PrintString
    _T26 = "\n"
    parm _T26
    call _PrintString
    _T27 = "\n"
    parm _T27
    call _PrintString
    _T28 = (_T3 + _T4)
    _T5 = _T28
    _T29 = (_T3 + _T7)
    _T5 = _T29
    _T30 = "0j"
    _T31 = (_T3 + _T30)
    _T5 = _T31
    _T32 = "0j"
    _T33 = (_T32 + _T7)
    _T5 = _T33
    _T34 = 4
    _T35 = (_T34 + _T7)
    _T10 = _T35
    parm _T10
    call _PrintInt
    _T36 = "\n"
    parm _T36
    call _PrintString
    _T37 = "\n"
    parm _T37
    call _PrintString
    _T38 = (_T3 * _T4)
    _T5 = _T38
    _T39 = (_T3 * _T7)
    _T5 = _T39
    _T40 = "0j"
    _T41 = (_T3 * _T40)
    _T5 = _T41
    _T42 = "0j"
    _T43 = (_T42 * _T7)
    _T5 = _T43
    _T44 = 4
    _T45 = (_T44 * _T7)
    _T10 = _T45
    parm _T10
    call _PrintInt
    _T46 = "\n"
    parm _T46
    call _PrintString
    _T47 = "\n"
    parm _T47
    call _PrintString
}

